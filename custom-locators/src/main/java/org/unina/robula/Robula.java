package org.unina.robula;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.unina.robulaplus.RobulaPlus;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Robula {
    /**
     * Generates a robust XPath for the given absolute XPath (or target element).
     *
     * @param absoluteXPath An existing absolute XPath to identify the target initially.
     * @param document      The Jsoup Document.
     * @return The generated robust XPath string.
     */
    public String getRobustXPath(String absoluteXPath, Document document) {
        Elements matches = Utils.eval(absoluteXPath, document);
        if (matches.isEmpty()) return null;

        Element targetElement = matches.first();
        return generateRobulaXPath(targetElement, document);
    }

    /**
     * Overload to work directly with an Element.
     */
    public String generateRobulaXPath(Element targetElement, Document document) {
        List<Element> ancestors = Utils.getAncestors(targetElement);

        LinkedList<String> p = new LinkedList<>();
        p.add("//*");
        List<String> temp = new ArrayList<>();
        List<String> visited = new ArrayList<>();

        while (!p.isEmpty()) {
            String w = p.removeFirst();
            if (visited.contains(w)) continue;
            visited.add(w);

            temp.clear();
            int N = Utils.getXPathLength(w);

            if (w.startsWith("//*")) {
                temp.addAll(Transformations.transf1(w, N, ancestors));
            } else {
                temp.addAll(Transformations.transf2(w, N, ancestors));
                temp.addAll(Transformations.transf3(w, N, ancestors));
            }
            if (N < ancestors.size()) {
                temp.addAll(Transformations.transf4(w));
            }

            for (String x : temp) {
                if (Utils.uniquelyLocate(x, targetElement, document)) {
                    return x;
                } else if (Utils.locate(x, targetElement, document)) {
                    p.add(x);
                }
            }
        }

        return ""; // Failed to find
    }

    public static void main(String[] args) {
        record element(String name, String xpath, String source){}
        List<element> elements = new ArrayList<>();
        elements.add(new element("SongsNavbar", "/html[1]/body[1]/angular-spotify-root[1]/as-layout[1]/as-nav-bar[1]/ul[1]/li[6]/a[1]", "home.html"));
        elements.add(new element("FirstSong", "/html[1]/body[1]/angular-spotify-root[1]/as-layout[1]/as-main-view[1]/div[2]/as-tracks[1]/div[1]/div[1]/as-playlist-track[1]/as-media-table-row[1]/as-track-main-info[1]", "liked-songs.html"));
        elements.add(new element("NavHome", "/html[1]/body[1]/angular-spotify-root[1]/as-layout[1]/as-nav-bar[1]/ul[1]/li[1]/a[1]", "home.html"));
        elements.add(new element("NowPlaying", "/html[1]/body[1]/angular-spotify-root[1]/as-layout[1]/as-now-playing-bar[1]/footer[1]/div[1]/as-track-current-info[1]/div[2]/div[1]/a[1]", "home.html"));
        elements.add(new element("PlayBtn", "/html[1]/body[1]/angular-spotify-root[1]/as-layout[1]/as-now-playing-bar[1]/footer[1]/div[2]/as-player-controls[1]/div[1]/as-play-button[1]/button[1]", "home.html"));
        elements.add(new element("NextBtn", "/html[1]/body[1]/angular-spotify-root[1]/as-layout[1]/as-now-playing-bar[1]/footer[1]/div[2]/as-player-controls[1]/div[1]/div[2]", "home.html"));

        Robula robula = new Robula();
        for (element e: elements) {
            try {
                InputStream inputStream = RobulaPlus.class.getClassLoader().getResourceAsStream(e.source);

                if (inputStream == null) {
                    throw new IllegalArgumentException("File not found");
                }
                Document doc = Jsoup.parse(inputStream, "UTF-8", "");
                String abs = e.xpath;

                String xpath = robula.getRobustXPath(abs, doc);
                System.out.println("Generated XPath for " + e.name + ": " + xpath);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
