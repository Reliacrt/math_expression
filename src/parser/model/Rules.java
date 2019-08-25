package parser.model;

import parser.model.base.Type;
import util.Node;
import util.container.CachedMap;
import util.container.MulValMap;

import java.util.ArrayList;
import java.util.List;

public class Rules {
    private CachedMap<Type, Node<Type>> nodeMap;
    private MulValMap<Type, List<Type>> ruleMap;
    private Node<Type> allRulesRoot;

    public Rules() {
        this.ruleMap = new MulValMap<>(ArrayList::new);
        this.nodeMap = new CachedMap<>();
        this.nodeMap.putFunc(Node::new);
        this.allRulesRoot = Node.nil();
    }

    public void putRule(Type type, List<Type> list) {
        ruleMap.put(type, list);
        Node<Type> node = allRulesRoot;
        for (Type t : list) {
            node = node.addChild(typeToNode(t));
        }
    }

    private Node<Type> typeToNode(Type type) {
        return nodeMap.get(Node::new, type);
    }
}
