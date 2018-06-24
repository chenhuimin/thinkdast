package com.allendowney.thinkdast;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class WikiNodeExample {
    public static void main(String[] args) throws IOException {
        String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
        Connection conn = Jsoup.connect(url);
        Document doc = conn.get();
        Element content = doc.getElementById("mw-content-text");
        Elements paras = content.select("p");
        Element firstPara = paras.get(0);
        recursiveDFS(firstPara);
        System.out.println();
        iterativeDFS(firstPara);


    }

    private static void iterativeDFS(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node instanceof TextNode) {
                System.out.print(node);
            }
            List<Node> nodes = new ArrayList<>(node.childNodes());
            Collections.reverse(nodes);
            for (Node child : nodes) {
                stack.push(child);
            }

        }
    }

    private static void recursiveDFS(Node node) {
        if (node instanceof TextNode) {
            System.out.print(node);
        }
        for (Node child : node.childNodes()) {
            recursiveDFS(child);
        }
    }
}
