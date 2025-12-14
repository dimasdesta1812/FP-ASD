import java.util.*;

public class Node {
    String name;
    List<Node> neighbors;
    int x, y; // Koordinat untuk visualisasi
    boolean isMainCategory; // true untuk kategori utama (kuning), false untuk subkategori (putih)

    public Node(String name, int x, int y, boolean isMainCategory) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.isMainCategory = isMainCategory;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Node neighbor) {
        if (!neighbors.contains(neighbor)) {
            neighbors.add(neighbor);
        }
    }
}