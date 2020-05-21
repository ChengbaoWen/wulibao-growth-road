package com.wulibao.provider.node;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * list转树形结构
 * 
 * @author WuliBao
 * @date 2020-05-21
 */
public class NodeMain {
    public static void main(String[] args) {
        Node node1 = new Node(1L, 0L, "吉林省");
        Node node2 = new Node(2L, 0L, "黑龙江省");
        Node node3 = new Node(3L, 1L, "长春市");
        Node node4 = new Node(4L, 2L, "哈尔滨市");
        Node node5 = new Node(5L, 3L, "二道区");
        Node node6 = new Node(6L, 3L, "经开区");
        List<Node> list = new ArrayList<>();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);
        list.add(node6);
        List<Node> nodes = buildTree(list);
        System.out.println(nodes);
    }
    
    // 把一个List转成树
    static List<Node> buildTree(List<Node> list) {
        List<Node> tree = new ArrayList<>();
        for (Node node : list) {
            if (node.getPid() == 0L) {
                tree.add(findChild(node, list));
            }
        }
        return tree;
    }
    
    static Node findChild(Node node, List<Node> list) {
        for (Node n : list) {
            if (n.getPid().equals(node.getId())) {
                if (node.getNodes() == null) {
                    node.setNodes(new ArrayList<>());
                }
                node.getNodes().add(findChild(n, list));
            }
        }
        return node;
    }
    
    @Data
    static class Node {
        
        private Long id;
        
        private Long pid;
        
        private String name;
        
        private List<Node> nodes;
        
        public Node(Long id, Long pid, String name) {
            this.id = id;
            this.pid = pid;
            this.name = name;
            this.nodes = new ArrayList<>();
        }
    }
}
