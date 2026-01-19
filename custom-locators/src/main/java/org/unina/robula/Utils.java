package org.unina.robula;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    /**
     * Evaluates an XPath expression on a Jsoup Document.
     * Note: Requires Jsoup 1.14.3+.
     *
     * @param xpath The XPath string.
     * @param doc   The Jsoup Document.
     * @return A list of matching Elements.
     */
    public static Elements eval(String xpath, Document doc) {
        try {
            return doc.selectXpath(xpath);
        } catch (Exception e) {
            // Return empty list if XPath is invalid during generation
            return new Elements();
        }
    }

    /**
     * Checks if the XPath uniquely locates the target element.
     * Corresponds to 'uniquelyLocate' in the paper.
     */
    public static boolean uniquelyLocate(String xpath, Element target, Document doc) {
        Elements found = eval(xpath, doc);
        return found.size() == 1 && found.first() == target;
    }

    /**
     * Checks if the XPath locates the target element (among others).
     * Corresponds to 'locate' in the paper.
     */
    public static boolean locate(String xpath, Element target, Document doc) {
        Elements found = eval(xpath, doc);
        return found.contains(target);
    }

    /**
     * Returns the list of ancestors starting from the element itself up to the root.
     * Paper definition of L: [element, parent, grandparent, ..., root]
     */
    public static List<Element> getAncestors(Element e) {
        List<Element> ancestors = new ArrayList<>();
        ancestors.add(e); // L includes e
        ancestors.addAll(e.parents()); // Jsoup parents() returns [parent, grandparent...]
        return ancestors;
    }

    /**
     * Calculates the length (N) of the XPath in terms of levels.
     * E.g., //tr/td -> 2
     */
    public static int getXPathLength(String xpath) {
        String[] parts = xpath.split("/");
        int count = 0;
        for (String p : parts) {
            if (!p.trim().isEmpty()) count++;
        }
        return count;
    }
}
