package com.wulibao.provider.node;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * list转树形结构
 * 
 * @author WuliBao
 * @date 2020-05-21
 */
public class NodeMain {
    public static void main(String[] args) {
        Area node1 = new Area(1L, 0L, "吉林省");
        Area node2 = new Area(2L, 0L, "黑龙江省");
        Area node3 = new Area(3L, 1L, "长春市");
        Area node4 = new Area(4L, 2L, "哈尔滨市");
        Area node5 = new Area(5L, 3L, "二道区");
        Area node6 = new Area(6L, 3L, "经开区");
        List<Area> list = new ArrayList<>();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);
        list.add(node6);
        List<Area> nodes = buildTree(list);
        System.out.println(nodes);
    }
    
    /**
     * 转换成树
     * 
     * @param list list
     * @param <T> <T>
     * @return T
     */
    static <T extends Node<T>> List<T> buildTree(List<T> list) {
        List<T> tree = new ArrayList<>();
        for (T node : list) {
            if (Long.valueOf(0L).equals(node.getParentId())) {
                tree.add(findChild(node, list));
            }
        }
        return tree;
    }
    
    /**
     * 递归方式找寻子节点
     * 
     * @param node node
     * @param list list
     * @param <T> <T>
     * @return T
     */
    static <T extends Node<T>> T findChild(T node, List<T> list) {
        for (T n : list) {
            if (n.getParentId().equals(node.getId())) {
                if (node.getNodes() == null) {
                    node.setNodes(new ArrayList<>());
                }
                node.getNodes().add(findChild(n, list));
            }
        }
        return node;
    }
    
    @Data
    @EqualsAndHashCode(callSuper = true)
    static class Area extends Node<Area> {
        private String area;
        
        public Area(Long id, Long parentId, String area) {
            super.setId(id);
            super.setParentId(parentId);
            this.area = area;
        }
    }
    
    @Data
    static class Node<T extends Node<T>> {
        
        /**
         * 节点ID
         */
        private Long id;
        
        /**
         * 父节点ID
         */
        private Long parentId;
        
        /**
         * 子节点
         */
        private List<T> nodes;
    }
}
