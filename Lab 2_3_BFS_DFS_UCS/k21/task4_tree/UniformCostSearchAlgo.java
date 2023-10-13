package k21.task4_tree;

import java.util.PriorityQueue;

public class UniformCostSearchAlgo implements ISearchAlgo {
    PriorityQueue<Node> priorityQueue;

    @Override
    public Node execute(Node root, String goal) {
        priorityQueue = new PriorityQueue();
        priorityQueue.add(root);
        Node current;
        while (!priorityQueue.isEmpty()) {
            current = priorityQueue.poll();
            System.out.println(current.getLabel());
            if (current.getLabel().equals(goal)) {
                return current;
            }

            duyet(current);
        }

        return null;
    }

    private void duyet(Node current){
        for (Edge child : current.getChildren()) {
            Node nodeChild = null;
            try {
                nodeChild = (Node) child.getEnd().clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
            child.setEnd(nodeChild);
            nodeChild.setPathCost(current.getPathCost() + child.getWeight());
            priorityQueue.add(child.getEnd());
            nodeChild.setParent(current);
            nodeChild.setDepth(current.getDepth() + 1);
        }
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        Node nodeStart = execute(root, start);
        nodeStart.setParent(null);
        System.out.println("================================================");
        nodeStart.setPathCost(0);
        return execute(nodeStart, goal);
    }
}