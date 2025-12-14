import java.util.*;

public class LibraryGraph {
    private Map<String, Node> nodes;
    private Map<String, List<String>> categories;

    public LibraryGraph() {
        nodes = new HashMap<>();
        categories = new HashMap<>();
        initializeGraph();
    }

    private void initializeGraph() {
        // Inisialisasi semua node sesuai gambar
        addNode("GATE", 60, 300, false);

        // Children Books dan subkategorinya
        addNode("Children Books", 180, 120, true);
        addNode("Knowledge Book", 100, 80, false);
        addNode("Activity Book", 100, 150, false);
        addNode("Math Book", 150, 200, false);
        addNode("Fairy Tail", 200, 200, false);
        addNode("Fantasy", 250, 180, false);

        // Comics dan subkategorinya
        addNode("Comics", 380, 120, true);
        addNode("Fantasy Comics", 350, 80, false);
        addNode("Romance Comics", 380, 80, false);
        addNode("Horror & Thriller", 420, 200, false);
        addNode("Action", 480, 150, false);

        // School Books dan subkategorinya
        addNode("School Books", 580, 120, true);
        addNode("Physics", 520, 50, false);
        addNode("Biology", 580, 30, false);
        addNode("Chemistry", 640, 50, false);
        addNode("Mathematics", 700, 80, false);
        addNode("Science", 720, 140, false);

        // Novel dan subkategorinya
        addNode("Novel", 780, 120, true);
        addNode("Adventure", 850, 50, false);
        addNode("Science Fiction", 870, 90, false);
        addNode("Fantasy Novel", 870, 130, false);
        addNode("Romance", 820, 150, false);
        addNode("Action Novel", 900, 110, false);
        addNode("Thriller", 930, 150, false);
        addNode("Horror", 880, 180, false);

        // Kategori khusus
        addNode("Top 10 Novel", 580, 240, true);
        addNode("New Arrival", 580, 360, true);
        addNode("Recommended Books", 680, 320, true);

        // Religion dan subkategorinya
        addNode("Religion", 850, 300, true);
        addNode("Spirituality", 820, 260, false);
        addNode("History", 900, 270, false);
        addNode("Scripture", 950, 300, false);
        addNode("Theology", 920, 340, false);
        addNode("Philosophy", 900, 380, false);
        addNode("Kedhikhasan", 850, 420, false);
        addNode("TKA", 950, 450, false);

        // Reference dan subkategorinya
        addNode("Reference", 850, 450, true);
        addNode("IELTS", 920, 480, false);
        addNode("TOEFL TEFL", 950, 520, false);

        // Best Seller dan subkategorinya
        addNode("Best Seller", 580, 500, true);
        addNode("Receipt", 520, 540, false);

        // Food & Beverage dan subkategorinya
        addNode("Food & Beverage", 750, 550, true);
        addNode("Tips & Trick", 800, 600, false);

        // Improvement dan subkategorinya
        addNode("Improvement", 750, 650, true);
        addNode("Motivation", 820, 680, false);
        addNode("Mental Health", 700, 700, false);
        addNode("Self Development", 720, 760, false);

        // Dictionary dan subkategorinya
        addNode("Dictionary", 850, 700, true);
        addNode("Indonesia", 920, 750, false);
        addNode("Korean", 980, 730, false);
        addNode("Japan", 950, 780, false);
        addNode("English", 880, 800, false);
        addNode("Others", 950, 820, false);

        // Business & Economics dan subkategorinya
        addNode("Business & Economics", 180, 700, true);
        addNode("Business Finance", 120, 750, false);
        addNode("Managerial Economics", 100, 800, false);
        addNode("Entrepre neurship", 180, 800, false);
        addNode("Economic Data Analysis", 240, 820, false);

        // Social Science dan subkategorinya
        addNode("Social Science", 380, 700, true);
        addNode("Law Book", 320, 650, false);
        addNode("Anthropology", 420, 680, false);
        addNode("Phsycology", 380, 760, false);
        addNode("Historical", 320, 760, false);

        // Parenting & Family dan subkategorinya
        addNode("Parenting & Family", 580, 800, true);
        addNode("Mental Health Parent", 520, 850, false);
        addNode("Practical Parenting", 600, 880, false);
        addNode("Childhood Education", 680, 860, false);

        // Membuat koneksi antar node sesuai gambar
        createConnections();

        // Inisialisasi kategori dan subkategori
        initializeCategories();
    }

    private void addNode(String name, int x, int y, boolean isMainCategory) {
        nodes.put(name, new Node(name, x, y, isMainCategory));
    }

    private void createConnections() {
        // Koneksi dari GATE (pintu masuk)
        connect("GATE", "Children Books");
        connect("GATE", "Business & Economics");
        connect("GATE", "Social Science");
        connect("GATE", "Parenting & Family");

        // Area Children Books (kiri atas)
        connect("Children Books", "Comics");
        connect("Children Books", "Knowledge Book");
        connect("Children Books", "Activity Book");
        connect("Children Books", "Math Book");
        connect("Children Books", "Fairy Tail");
        connect("Children Books", "Fantasy");

        // Area Comics (tengah atas)
        connect("Comics", "Children Books");
        connect("Comics", "School Books");
        connect("Comics", "Fantasy Comics");
        connect("Comics", "Romance Comics");
        connect("Comics", "Horror & Thriller");
        connect("Comics", "Action");

        // Area School Books (tengah atas)
        connect("School Books", "Comics");
        connect("School Books", "Novel");
        connect("School Books", "Physics");
        connect("School Books", "Biology");
        connect("School Books", "Chemistry");
        connect("School Books", "Mathematics");
        connect("School Books", "Science");
        connect("School Books", "Top 10 Novel");

        // Area Novel (kanan atas)
        connect("Novel", "School Books");
        connect("Novel", "Adventure");
        connect("Novel", "Science Fiction");
        connect("Novel", "Fantasy Novel");
        connect("Novel", "Romance");
        connect("Novel", "Action Novel");
        connect("Novel", "Thriller");
        connect("Novel", "Horror");
        connect("Novel", "Top 10 Novel");

        // Area tengah (Top 10 Novel, New Arrival, Recommended Books)
        connect("Top 10 Novel", "School Books");
        connect("Top 10 Novel", "Novel");
        connect("Top 10 Novel", "New Arrival");
        connect("Top 10 Novel", "Recommended Books");

        connect("New Arrival", "Top 10 Novel");
        connect("New Arrival", "Recommended Books");
        connect("New Arrival", "Best Seller");

        connect("Recommended Books", "Top 10 Novel");
        connect("Recommended Books", "New Arrival");
        connect("Recommended Books", "Religion");
        connect("Recommended Books", "Best Seller");

        // Area Religion (kanan tengah)
        connect("Religion", "Recommended Books");
        connect("Religion", "Reference");
        connect("Religion", "Spirituality");
        connect("Religion", "History");
        connect("Religion", "Scripture");
        connect("Religion", "Theology");
        connect("Religion", "Philosophy");
        connect("Religion", "Kedhikhasan");
        connect("Religion", "TKA");

        // Area Reference (kanan bawah)
        connect("Reference", "Religion");
        connect("Reference", "Recommended Books");
        connect("Reference", "Best Seller");
        connect("Reference", "Dictionary");
        connect("Reference", "IELTS");
        connect("Reference", "TOEFL TEFL");

        // Area Best Seller (tengah bawah)
        connect("Best Seller", "New Arrival");
        connect("Best Seller", "Recommended Books");
        connect("Best Seller", "Reference");
        connect("Best Seller", "Food & Beverage");
        connect("Best Seller", "Dictionary");
        connect("Best Seller", "Receipt");

        // Area Food & Beverage
        connect("Food & Beverage", "Best Seller");
        connect("Food & Beverage", "Tips & Trick");
        connect("Food & Beverage", "Improvement");

        // Area Improvement
        connect("Improvement", "Food & Beverage");
        connect("Improvement", "Dictionary");
        connect("Improvement", "Motivation");
        connect("Improvement", "Mental Health");
        connect("Improvement", "Self Development");

        // Area Dictionary (tengah bawah)
        connect("Dictionary", "Reference");
        connect("Dictionary", "Best Seller");
        connect("Dictionary", "Improvement");
        connect("Dictionary", "Social Science");
        connect("Dictionary", "Parenting & Family");
        connect("Dictionary", "Indonesia");
        connect("Dictionary", "Korean");
        connect("Dictionary", "Japan");
        connect("Dictionary", "English");
        connect("Dictionary", "Others");

        // Area Business & Economics (kiri bawah)
        connect("Business & Economics", "GATE");
        connect("Business & Economics", "Social Science");
        connect("Business & Economics", "Business Finance");
        connect("Business & Economics", "Managerial Economics");
        connect("Business & Economics", "Entrepre neurship");
        connect("Business & Economics", "Economic Data Analysis");

        // Area Social Science (kiri bawah tengah)
        connect("Social Science", "GATE");
        connect("Social Science", "Business & Economics");
        connect("Social Science", "Dictionary");
        connect("Social Science", "Parenting & Family");
        connect("Social Science", "Law Book");
        connect("Social Science", "Anthropology");
        connect("Social Science", "Phsycology");
        connect("Social Science", "Historical");

        // Area Parenting & Family (kiri bawah)
        connect("Parenting & Family", "GATE");
        connect("Parenting & Family", "Social Science");
        connect("Parenting & Family", "Dictionary");
        connect("Parenting & Family", "Mental Health Parent");
        connect("Parenting & Family", "Practical Parenting");
        connect("Parenting & Family", "Childhood Education");
    }

    private void connect(String node1, String node2) {
        Node n1 = nodes.get(node1);
        Node n2 = nodes.get(node2);
        if (n1 != null && n2 != null) {
            n1.addNeighbor(n2);
            n2.addNeighbor(n1);
        }
    }

    private void initializeCategories() {
        categories.put("Children Books", Arrays.asList("Knowledge Book", "Activity Book", "Math Book", "Fairy Tail", "Fantasy"));
        categories.put("Comics", Arrays.asList("Fantasy Comics", "Romance Comics", "Horror & Thriller", "Action"));
        categories.put("School Books", Arrays.asList("Physics", "Biology", "Chemistry", "Mathematics", "Science"));
        categories.put("Novel", Arrays.asList("Adventure", "Science Fiction", "Fantasy Novel", "Romance", "Action Novel", "Thriller", "Horror"));
        categories.put("Top 10 Novel", new ArrayList<>());
        categories.put("New Arrival", new ArrayList<>());
        categories.put("Recommended Books", new ArrayList<>());
        categories.put("Religion", Arrays.asList("Spirituality", "History", "Scripture", "Theology", "Philosophy", "Kedhikhasan", "TKA"));
        categories.put("Reference", Arrays.asList("IELTS", "TOEFL TEFL"));
        categories.put("Best Seller", Arrays.asList("Receipt"));
        categories.put("Food & Beverage", Arrays.asList("Tips & Trick"));
        categories.put("Improvement", Arrays.asList("Motivation", "Mental Health", "Self Development"));
        categories.put("Dictionary", Arrays.asList("Indonesia", "Korean", "Japan", "English", "Others"));
        categories.put("Business & Economics", Arrays.asList("Business Finance", "Managerial Economics", "Entrepre neurship", "Economic Data Analysis"));
        categories.put("Social Science", Arrays.asList("Law Book", "Anthropology", "Phsycology", "Historical"));
        categories.put("Parenting & Family", Arrays.asList("Mental Health Parent", "Practical Parenting", "Childhood Education"));
    }

    // BFS Algorithm
    public List<String> bfs(String start, String end) {
        if (!nodes.containsKey(start) || !nodes.containsKey(end)) {
            return null;
        }

        Queue<List<String>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        List<String> initialPath = new ArrayList<>();
        initialPath.add(start);
        queue.offer(initialPath);
        visited.add(start);

        while (!queue.isEmpty()) {
            List<String> path = queue.poll();
            String current = path.get(path.size() - 1);

            if (current.equals(end)) {
                return path;
            }

            Node currentNode = nodes.get(current);
            for (Node neighbor : currentNode.neighbors) {
                if (!visited.contains(neighbor.name)) {
                    visited.add(neighbor.name);
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(neighbor.name);
                    queue.offer(newPath);
                }
            }
        }

        return null;
    }

    // Dijkstra Algorithm
    public List<String> dijkstra(String start, String end) {
        if (!nodes.containsKey(start) || !nodes.containsKey(end)) {
            return null;
        }

        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<NodeDistance> pq = new PriorityQueue<>(Comparator.comparingInt(nd -> nd.distance));
        Set<String> visited = new HashSet<>();

        // Inisialisasi
        for (String nodeName : nodes.keySet()) {
            distances.put(nodeName, Integer.MAX_VALUE);
            previous.put(nodeName, null);
        }
        distances.put(start, 0);
        pq.offer(new NodeDistance(start, 0));

        while (!pq.isEmpty()) {
            NodeDistance current = pq.poll();
            String currentName = current.name;

            if (visited.contains(currentName)) continue;
            visited.add(currentName);

            if (currentName.equals(end)) break;

            Node currentNode = nodes.get(currentName);
            for (Node neighbor : currentNode.neighbors) {
                if (!visited.contains(neighbor.name)) {
                    int newDist = distances.get(currentName) + 1;
                    if (newDist < distances.get(neighbor.name)) {
                        distances.put(neighbor.name, newDist);
                        previous.put(neighbor.name, currentName);
                        pq.offer(new NodeDistance(neighbor.name, newDist));
                    }
                }
            }
        }

        // Reconstruct path
        List<String> path = new ArrayList<>();
        String current = end;
        while (current != null) {
            path.add(0, current);
            current = previous.get(current);
        }

        return path.isEmpty() || !path.get(0).equals(start) ? null : path;
    }

    // Helper class untuk Dijkstra
    private class NodeDistance {
        String name;
        int distance;

        NodeDistance(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }
    }

    // Getter methods
    public Map<String, Node> getNodes() {
        return nodes;
    }

    public Map<String, List<String>> getCategories() {
        return categories;
    }

    public Node getNode(String name) {
        return nodes.get(name);
    }

    public List<String> getMainCategories() {
        List<String> mainCats = new ArrayList<>();
        for (Map.Entry<String, Node> entry : nodes.entrySet()) {
            if (entry.getValue().isMainCategory) {
                mainCats.add(entry.getKey());
            }
        }
        Collections.sort(mainCats);
        return mainCats;
    }

    public void displayAllCategories() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║         DAFTAR KATEGORI DAN SUBKATEGORI BUKU               ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");

        List<String> mainCats = getMainCategories();
        int count = 1;

        for (String category : mainCats) {
            System.out.println("┌─ [" + count + "] " + category + " (KATEGORI UTAMA)");
            List<String> subcats = categories.get(category);
            if (subcats != null && !subcats.isEmpty()) {
                for (int i = 0; i < subcats.size(); i++) {
                    String prefix = (i == subcats.size() - 1) ? "   └──" : "   ├──";
                    System.out.println(prefix + " " + subcats.get(i));
                }
            } else {
                System.out.println("   └── (Tidak ada subkategori)");
            }
            System.out.println();
            count++;
        }
    }

    public void displayMap() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                  MEMBUKA PETA PERPUSTAKAAN                    ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");

        // Coba buka gambar peta
        String[] possibleFiles = {
                "peta_perpustakaan.png",
                "peta_perpustakaan.jpg",
                "peta_perpustakaan.jpeg",
                "peta.png",
                "peta.jpg"
        };

        boolean imageOpened = false;

        for (String filename : possibleFiles) {
            java.io.File imageFile = new java.io.File(filename);
            if (imageFile.exists()) {
                System.out.println("📍 Membuka gambar peta: " + filename);
                System.out.println("⏳ Tunggu sebentar...\n");

                try {
                    // Deteksi OS dan buka gambar
                    String os = System.getProperty("os.name").toLowerCase();

                    if (os.contains("win")) {
                        // Windows
                        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + imageFile.getAbsolutePath());
                    } else if (os.contains("mac")) {
                        // MacOS
                        Runtime.getRuntime().exec("open " + imageFile.getAbsolutePath());
                    } else {
                        // Linux
                        Runtime.getRuntime().exec("xdg-open " + imageFile.getAbsolutePath());
                    }

                    System.out.println("✅ Gambar peta berhasil dibuka!");
                    imageOpened = true;
                    break;

                } catch (Exception e) {
                    System.out.println("❌ Gagal membuka gambar: " + e.getMessage());
                }
            }
        }

        if (!imageOpened) {
            System.out.println("⚠  Gambar peta tidak ditemukan!");
            System.out.println("\n💡 Petunjuk:");
            System.out.println("   1. Simpan gambar peta dengan nama:");
            System.out.println("      - peta_perpustakaan.png (atau .jpg)");
            System.out.println("      - peta.png (atau .jpg)");
            System.out.println("   2. Letakkan di folder yang sama dengan file Main.java");
            System.out.println("   3. Coba lagi menu ini\n");

            // Tampilkan ASCII map sebagai backup
            System.out.println("📋 Menampilkan peta text sebagai alternatif:\n");
            displayTextMap();
        }

        System.out.println("\n═══════════════════════════════════════════════════════════════");
    }

    private void displayTextMap() {
        System.out.println("  ┌──────────┐         ┌──────────────┐         ┌──────────┐");
        System.out.println("  │  Comics  │         │ School Books │         │   Novel  │");
        System.out.println("  └──────────┘         └──────────────┘         └──────────┘");
        System.out.println("  │  Fantasy │         │ Mathematics  │         │ Romance  │");
        System.out.println("  ├──────────┤         ├──────────────┤         ├──────────┤");
        System.out.println("  │ Romance  │         │   Physics    │         │ Horror   │");
        System.out.println("  ├──────────┤         ├──────────────┤         ├──────────┤         ┌──────────┐");
        System.out.println("  │  Action  │         │   Biology    │         │ Thriller │         │  Horror  │");
        System.out.println("  ├──────────┤         ├──────────────┤         ├──────────┤         ├──────────┤");
        System.out.println("  │ICBIIIIRC │         │  Chemistry   │         │ Science  │         │ Adventure│");
        System.out.println("  ├──────────┤         ├──────────────┤         │ Fiction  │         ├──────────┤");
        System.out.println("  │Horror &  │         │   Science    │         ├──────────┤         │  Action  │");
        System.out.println("  │Thriller  │         └──────────────┘         │ Fantasy  │         └──────────┘");
        System.out.println("  ├──────────┤                │                 │  Novel   │");
        System.out.println("  │ Fantasy  │                │                 └──────────┘              │");
        System.out.println("  │ Comics   │                │                      │                    │");
        System.out.println("  └──────────┘                │                      │                    │");
        System.out.println("                              │                 ┌────┴────┐               │");
        System.out.println("┌────────────┐                │                 │Top 10   │               │");
        System.out.println("│ Children   │                │                 │ Novel   │               │");
        System.out.println("│   Books    │                │                 └─────────┘               │");
        System.out.println("├────────────┤                │                      │                    │");
        System.out.println("│ Knowledge  │                │                      │                    │");
        System.out.println("│    Book    │                │                 ┌────┴─────┐              │");
        System.out.println("├────────────┤                │                 │   New    │         ┌────┴─────┐");
        System.out.println("│ Activity   │                │                 │ Arrival  │         │Recommend │");
        System.out.println("│    Book    │                │                 └──────────┘         │  Books   │");
        System.out.println("├────────────┤                │                      │                └──────────┘");
        System.out.println("│ Math Book  │                │                      │                     │");
        System.out.println("├────────────┤                │                 ┌────┴─────┐               │");
        System.out.println("│ Fairy Tail │                │                 │   Best   │               │");
        System.out.println("├────────────┤                │                 │  Seller  │               │");
        System.out.println("│  Fantasy   │                │                 └──────────┘               │");
        System.out.println("└────────────┘                │                      │                     │");
        System.out.println("      │                       │                      │                ┌────┴─────┐");
        System.out.println("      │                       │                 ┌────┴─────┐          │ Religion │");
        System.out.println("      │                       │                 │   Food   │          ├──────────┤");
        System.out.println("  ┌───┴────┐                  │                 │Beverage  │          │Scripture │");
        System.out.println("  │  GATE  │                  │                 └──────────┘          ├──────────┤");
        System.out.println("  │(START) │                  │                      │                │ Theology │");
        System.out.println("  └───┬────┘                  │                      │                ├──────────┤");
        System.out.println("      │                       │                 ┌────┴──────┐         │Philosophy│");
        System.out.println("      │                  ┌────┴─────┐           │Improvement│         ├──────────┤");
        System.out.println("┌─────┴──────┐           │  School  │           ├───────────┤         │ History  │");
        System.out.println("│  Business  │           │  Books   │           │Motivation │         ├──────────┤");
        System.out.println("│ Economics  │           └──────────┘           ├───────────┤         │Spiritual │");
        System.out.println("├────────────┤                                  │  Mental   │         └──────────┘");
        System.out.println("│  Economic  │           ┌──────────┐           │  Health   │              │");
        System.out.println("│   Data     │           │  Comics  │           ├───────────┤              │");
        System.out.println("│  Analysis  │           └──────────┘           │   Self    │         ┌────┴─────┐");
        System.out.println("├────────────┤                                  │Development│         │Reference │");
        System.out.println("│  Business  │                                  └───────────┘         ├──────────┤");
        System.out.println("│ Economics  │                                       │                │   TKA    │");
        System.out.println("├────────────┤                                       │                ├──────────┤");
        System.out.println("│Entrepreneur│           ┌──────────┐          ┌────┴─────┐          │Kedhikhsn │");
        System.out.println("│    ship    │           │  Social  │          │Dictionary│          ├──────────┤");
        System.out.println("├────────────┤           │ Science  │          ├──────────┤          │   IELTS  │");
        System.out.println("│ Managerial │           ├──────────┤          │  Korean  │          ├──────────┤");
        System.out.println("│ Economics  │           │ Law Book │          ├──────────┤          │TOEFL TEFL│");
        System.out.println("├────────────┤           ├──────────┤          │Indonesia │          └──────────┘");
        System.out.println("│  Business  │           │  Social  │          ├──────────┤");
        System.out.println("│  Finance   │           │ Science  │          │   Japan  │");
        System.out.println("└────────────┘           ├──────────┤          ├──────────┤");
        System.out.println("                         │Historical│          │ English  │");
        System.out.println("                         ├──────────┤          ├──────────┤          ┌──────────┐");
        System.out.println("                         │  Social  │          │Kacamasan │          │TNI & Purn│");
        System.out.println("                         │ Science  │          └──────────┘          └──────────┘");
        System.out.println("                         ├──────────┤");
        System.out.println("                         │Phsycology│          ┌──────────┐");
        System.out.println("                         ├──────────┤          │Parenting │");
        System.out.println("                         │Anthroplgy│          │  Family  │");
        System.out.println("                         └──────────┘          ├──────────┤");
        System.out.println("                                               │  Mental  │");
        System.out.println("                         ┌──────────┐          │  Health  │");
        System.out.println("                         │Parenting │          │  Parent  │");
        System.out.println("                         │ Family   │          ├──────────┤");
        System.out.println("                         ├──────────┤          │ Practical│");
        System.out.println("                         │Childhood │          │ Parenting│");
        System.out.println("                         │Education │          ├──────────┤");
        System.out.println("                         └──────────┘          │Childhood │");
        System.out.println("                                               │Education │");
        System.out.println("                                               └──────────┘");

        System.out.println("\n═════════════════════════════════════════════════════════════");
        System.out.println("Keterangan:");
        System.out.println("  🚩 GATE = Pintu masuk perpustakaan (lokasi awal Anda)");
        System.out.println("  📚 Setiap kotak = Kategori atau rak buku");
        System.out.println("  │ ─ ┌ ┐ └ ┘ ├ ┤ = Koneksi antar rak");
        System.out.println("═════════════════════════════════════════════════════════════");
    }
}