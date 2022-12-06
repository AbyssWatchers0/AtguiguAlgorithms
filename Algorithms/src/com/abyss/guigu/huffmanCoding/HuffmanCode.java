package com.abyss.guigu.huffmanCoding;

import java.io.*;
import java.util.*;

/**
 * @author Abyss Watchers
 * @create 2022-12-01 22:15
 */
public class HuffmanCode {
    public static Map<Byte, String> codeMap;

    public static void main(String[] args) {
//        String content = "以前我是堆，你是栈\n" +
//                "你总是能精准的找到我，给我指明出路\n" +
//                "后来有一天我明白了\n" +
//                "我变成了栈，你却隐身堆海\n" +
//                "我找不到你了，空指针了\n" +
//                "我不愿意如此，在下一轮full gc前\n" +
//                "我找到了object家的finalize\n" +
//                "又找到了你，这次我不会放手";
//
//        byte[] bytes = huffmanZip(content.getBytes());
//        System.out.println(Arrays.toString(bytes));
//
//        String s = deZip(bytes);
//        System.out.println(s);

//        zipFile("C:\\Users\\ASUS\\Pictures\\ai女儿\\daughter5.png", "C:\\Users\\ASUS\\Downloads\\dg.zip");
//        deZipFile("C:\\Users\\ASUS\\Downloads\\dg.zip", "C:\\Users\\ASUS\\Downloads\\dg.png");

        String src = "F:\\DeskTop\\记事本.txt";
        String desc = "F:\\DeskTop\\note.rar";

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("0:压缩   1:解压");
            int op = scanner.nextInt();
            switch (op) {
                case 0:
                    System.out.println("源文件路径：");
                    src = scanner.next();
                    System.out.println("输出路径：");
                    desc = scanner.next();
                    zipFile(src, desc);
                    break;
                case 1:
                    System.out.println("源文件路径：");
                    src = scanner.next();
                    System.out.println("输出路径：");
                    desc = scanner.next();
                    deZipFile(src, desc);
                    break;
                default:
                    zipFile(src, desc);
                    deZipFile(desc, src);
            }
        }

    }

    @SuppressWarnings("unchecked")
    private static void deZipFile(String src, String dest) {
        ObjectInputStream ois = null;
        FileOutputStream fos = null;
        try {
            FileInputStream fis = new FileInputStream(src);
            ois = new ObjectInputStream(fis);
            byte[] zipBytes = (byte[]) ois.readObject();
            Object o = ois.readObject();
            if (o instanceof Map) {
                HuffmanCode.codeMap = (Map<Byte, String>) o;
            }
            byte[] bytes = deZip(zipBytes);
            fos = new FileOutputStream(dest);
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                assert ois != null;
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert fos != null;
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("解压成功！");
        }

    }

    private static void zipFile(String src, String dest) {
        FileInputStream fis = null;
        ObjectOutputStream oos = null;
        try {
            fis = new FileInputStream(src);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            byte[] zipBytes = huffmanZip(bytes);
            oos = new ObjectOutputStream(new FileOutputStream(dest));
            oos.writeObject(zipBytes);
            oos.writeObject(codeMap);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("压缩成功！");
        }

    }

    /**
     * 解压
     *
     * @param bytes
     * @return
     */
    private static byte[] deZip(byte[] bytes) {
        // 压缩数据转换为赫夫曼编码
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length - 2; i++) {
            stringBuilder.append(byteToString(bytes[i], 8));
        }
        stringBuilder.append(byteToString(bytes[bytes.length - 2], bytes[bytes.length - 1]));
//        System.out.println("解压赫夫曼：" + stringBuilder.toString());

        // 赫夫曼编码解析成原数据
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> e : codeMap.entrySet()) {
            map.put(e.getValue(), e.getKey());
        }
//        System.out.println(map);

        ArrayList<Byte> res = new ArrayList<>();
        int left = 0;
        int right = 1;
        while (right <= stringBuilder.length()) {
            Byte b = map.get(stringBuilder.substring(left, right));
            if (b == null) {
                right++;
            } else {
                left = right;
                res.add(b);
            }
        }
        if (left + 1 != right) {
            System.out.println("压缩文件损坏");
        }

        byte[] b = new byte[res.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = res.get(i);
        }
        return b;
    }

    private static String byteToString(byte b, int lastLen) {
        int temp = b;
        temp |= 256;
        String string = Integer.toBinaryString(temp); // 返回的是补码
        if (string.length() > 8) {
            if (lastLen == 0) {
                lastLen = 8;
            }
            string = string.substring(string.length() - lastLen);
        }
//        System.out.println(string);
        return string;
    }

    /**
     * 赫夫曼数据压缩
     *
     * @param contentBytes 原数据
     * @return 经过赫夫曼编码处理后的字节数组
     */
    public static byte[] huffmanZip(byte[] contentBytes) {
//        System.out.println(contentBytes.length);

        List<Node> nodes = getNodes(contentBytes);
//        System.out.println(nodes);

        // 创建赫夫曼树
        Node root = generateHuffmanTree(nodes);
//        if (root != null) {
//            root.prefixOrder();
//        }

        // 生成赫夫曼编码集
        codeMap = getCode(root);
//        System.out.println(codeMap);

        // 压缩数据
        byte[] zip = zip(contentBytes, codeMap);

        System.out.println("压缩前" + contentBytes.length + "byte，压缩后" + zip.length + "byte，压缩率：" + (contentBytes.length - zip.length) / (float) contentBytes.length * 100 + "%");
        return zip;
    }

    /**
     * 压缩
     *
     * @param data    原数据
     * @param codeMap 赫夫曼编码集
     * @return 压缩后的数据
     */
    public static byte[] zip(byte[] data, Map<Byte, String> codeMap) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : data) {
            stringBuilder.append(codeMap.get(b));
        }

//        System.out.println("压缩赫夫曼：" + stringBuilder.toString());
        // 最后不足8位的部分有多长，保存在最后
        byte lastLen = (byte) (stringBuilder.length() % 8);
//        System.out.println("最后有" + lastLen + "位");
//        lastLen |= 256;
//        String string = Integer.toBinaryString(lastLen);
//        System.out.println(string.substring(string.length() - 8));

        // 能够分成几个8位字符串
        int len = (stringBuilder.length() + 7) / 8;

        // 创建存储压缩后的byte数组
        byte[] zipData = new byte[len + 1];

        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            if (i + 8 > stringBuilder.length()) {
                String s = stringBuilder.substring(i);
                zipData[index] = (byte) Integer.parseInt(s, 2);
            } else {
                String s = stringBuilder.substring(i, i + 8);
                zipData[index] = (byte) Integer.parseInt(s, 2);
            }
            index++;
        }
        zipData[len] = lastLen;
        return zipData;
    }

    /**
     * 把出现次数作为权值，字符的ASCII码作为数据，封装为Node保存到List集合中
     *
     * @param contentBytes 要压缩的内容的字节数组
     * @return
     */
    public static List<Node> getNodes(byte[] contentBytes) {
        List<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : contentBytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    /**
     * 生成赫夫曼树
     *
     * @param nodes 保存Node的List集合
     * @return
     */
    public static Node generateHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node node1 = nodes.get(0);
            Node node2 = nodes.get(1);
            Node node = new Node();
            node.setWeight(node1.getWeight() + node2.getWeight());
            node.setLeft(node1);
            node.setRight(node2);
            nodes.remove(node1);
            nodes.remove(node2);
            nodes.add(node);
        }
        return nodes.get(0);
    }

    /**
     * 获取赫夫曼编码表
     *
     * @param node 赫夫曼树的根节点
     * @return
     */
    public static Map<Byte, String> getCode(Node node) {
        Map<Byte, String> codeMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        getCode(node, "", stringBuilder, codeMap);
        return codeMap;
    }

    /**
     * 生成赫夫曼编码表
     *
     * @param node          当前节点
     * @param code          当前节点是上一个节点的 左节点：0，右节点：1
     * @param stringBuilder 记录目前为止的赫夫曼编码
     * @param codeMap       赫夫曼编码表
     */
    private static void getCode(Node node, String code, StringBuilder stringBuilder, Map<Byte, String> codeMap) {
        StringBuilder sb = new StringBuilder(stringBuilder);
        sb.append(code);
        if (node == null) {
            return;
        }
        if (node.getData() == null) { // 不是叶子节点
            getCode(node.getLeft(), "0", sb, codeMap);
            getCode(node.getRight(), "1", sb, codeMap);
        } else { // 是叶子节点
            codeMap.put(node.getData(), sb.toString());
        }
    }
}

class Node implements Comparable<Node> {
    private Byte data;
    private int weight;
    private Node left;
    private Node right;

    public Node() {
    }

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public Node(Byte data, int weight, Node left, Node right) {
        this.data = data;
        this.weight = weight;
        this.left = left;
        this.right = right;
    }

    public void prefixOrder() {
        System.out.println("data:" + this.data + ", weight:" + this.weight);
        if (this.getLeft() != null) {
            this.getLeft().prefixOrder();
        }
        if (this.getRight() != null) {
            this.getRight().prefixOrder();
        }
    }

    public Byte getData() {
        return data;
    }

    public void setData(Byte data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.getWeight();
    }
}
