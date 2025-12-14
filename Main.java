import java.util.*;

public class Main {
    private LibraryGraph library;
    private Scanner scanner;
    private String currentLocation;

    public Main() {
        library = new LibraryGraph();
        scanner = new Scanner(System.in);
        currentLocation = "GATE";
    }

    public void run() {
        displayWelcome();

        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    showCategories();
                    break;
                case 2:
                    showMap();
                    break;
                case 3:
                    navigateToDestination();
                    break;
                case 4:
                    searchCategory();
                    break;
                case 5:
                    changeCurrentLocation();
                    break;
                case 6:
                    turnByTurnNavigation();
                    break;
                case 0:
                    running = false;
                    displayGoodbye();
                    break;
                default:
                    System.out.println("❌ Pilihan tidak valid! Silakan coba lagi.");
            }

            if (running && choice != 0) {
                System.out.println("\nTekan Enter untuk melanjutkan...");
                scanner.nextLine();
            }
        }
    }

    private void displayWelcome() {
        clearScreen();
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                               ║");
        System.out.println("║        📚 SISTEM NAVIGASI PERPUSTAKAAN DIGITAL 📚             ║");
        System.out.println("║                                                               ║");
        System.out.println("║           Selamat Datang di Perpustakaan Kami!                ║");
        System.out.println("║                                                               ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.println("\n✨ Fitur:");
        System.out.println("   • 16 Kategori Utama Buku");
        System.out.println("   • Navigasi Cerdas Otomatis");
        System.out.println("   • Peta Perpustakaan Interaktif");
        System.out.println("   • Panduan Arah GPS Style");
        System.out.println("   • Pencarian Cepat Kategori\n");
        System.out.println("📍 Lokasi Anda saat ini: " + currentLocation);
        System.out.println("\nTekan Enter untuk memulai...");
        scanner.nextLine();
    }

    private void displayMainMenu() {
        clearScreen();
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                      MENU UTAMA                               ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.println("\n📍 Lokasi Anda: " + currentLocation + "\n");
        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│ 1. 📋 Lihat Semua Kategori & Subkategori                   │");
        System.out.println("│ 2. 🗺  Lihat Peta Perpustakaan                             │");
        System.out.println("│ 3. 🧭 Cari Jalur ke Tujuan                                 │");
        System.out.println("│ 4. 🔍 Cari Kategori Buku                                   │");
        System.out.println("│ 5. 📌 Ubah Lokasi Saat Ini                                 │");
        System.out.println("│ 6. 🧭 Panduan Arah (GPS Style)                             │");
        System.out.println("│ 0. 🚪 Keluar                                               │");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
        System.out.print("\nPilihan Anda: ");
    }

    private int getMenuChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }

    private void navigateToDestination() {
        clearScreen();
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    CARI JALUR KE TUJUAN                       ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");

        System.out.println("📍 Lokasi Saat Ini: " + currentLocation);
        System.out.println("\n🎯 Masukkan tujuan Anda: ");

        List<String> mainCats = library.getMainCategories();
        for (int i = 0; i < mainCats.size(); i++) {
            System.out.printf("   %2d. %s\n", (i + 1), mainCats.get(i));
        }

        System.out.print("\nPilih nomor kategori atau ketik nama: ");
        String input = scanner.nextLine().trim();

        String destination = parseDestination(input, mainCats);
        if (destination == null) {
            System.out.println("\n❌ Kategori tidak ditemukan!");
            return;
        }

        System.out.println("\n⏳ Mencari jalur terbaik...\n");
        long startTime = System.nanoTime();
        List<String> path = library.bfs(currentLocation, destination);
        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1_000_000.0;

        displayPathResult(path, destination, "Jalur Tercepat", executionTime);

        if (path != null && !path.isEmpty()) {
            System.out.print("\n🧭 Lihat panduan arah detail? (y/n): ");
            String showTurn = scanner.nextLine().trim().toLowerCase();
            if (showTurn.equals("y") || showTurn.equals("yes")) {
                List<NavigationDirection.DirectionInstruction> instructions =
                        NavigationDirection.generateInstructions(path, library.getNodes());
                NavigationDirection.displayCompactInstructions(instructions);
            }

            System.out.print("\n📍 Pindahkan lokasi Anda ke " + destination + "? (y/n): ");
            String updateLoc = scanner.nextLine().trim().toLowerCase();
            if (updateLoc.equals("y") || updateLoc.equals("yes")) {
                currentLocation = destination;
                System.out.println("✅ Lokasi diperbarui ke: " + currentLocation);
            }
        }
    }

    private void turnByTurnNavigation() {
        clearScreen();
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                  🧭 PANDUAN ARAH (GPS STYLE)                  ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");

        System.out.println("📍 Lokasi Saat Ini: " + currentLocation);
        System.out.println("\n🎯 Masukkan tujuan Anda: ");

        List<String> mainCats = library.getMainCategories();
        for (int i = 0; i < mainCats.size(); i++) {
            System.out.printf("   %2d. %s\n", (i + 1), mainCats.get(i));
        }

        System.out.print("\nPilih nomor kategori atau ketik nama: ");
        String input = scanner.nextLine().trim();

        String destination = parseDestination(input, mainCats);
        if (destination == null) {
            System.out.println("\n❌ Kategori tidak ditemukan!");
            return;
        }

        System.out.println("\n⏳ Menghitung rute terbaik...\n");
        List<String> path = library.bfs(currentLocation, destination);

        if (path == null || path.isEmpty()) {
            System.out.println("❌ Tidak dapat menemukan jalur ke tujuan!");
            return;
        }

        List<NavigationDirection.DirectionInstruction> instructions =
                NavigationDirection.generateInstructions(path, library.getNodes());

        NavigationDirection.displayNavigationInstructions(instructions, currentLocation, destination);

        System.out.print("\n💡 Tampilkan versi ringkas? (y/n): ");
        String showCompact = scanner.nextLine().trim().toLowerCase();
        if (showCompact.equals("y") || showCompact.equals("yes")) {
            NavigationDirection.displayCompactInstructions(instructions);
        }

        System.out.print("\n📍 Pindahkan lokasi Anda ke " + destination + "? (y/n): ");
        String updateLoc = scanner.nextLine().trim().toLowerCase();
        if (updateLoc.equals("y") || updateLoc.equals("yes")) {
            currentLocation = destination;
            System.out.println("✅ Lokasi diperbarui ke: " + currentLocation);
        }
    }

    private void showCategories() {
        clearScreen();
        library.displayAllCategories();
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.println("📊 Total: " + library.getMainCategories().size() + " kategori utama");
        System.out.println("═══════════════════════════════════════════════════════════════");
    }

    private void showMap() {
        clearScreen();
        library.displayMap();
    }

    private void searchCategory() {
        clearScreen();
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    PENCARIAN KATEGORI                         ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");

        System.out.print("🔍 Masukkan kata kunci pencarian: ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        System.out.println("\n📚 Hasil Pencarian:\n");

        Map<String, List<String>> categories = library.getCategories();
        boolean found = false;

        for (Map.Entry<String, List<String>> entry : categories.entrySet()) {
            String category = entry.getKey();
            List<String> subcats = entry.getValue();

            if (category.toLowerCase().contains(keyword)) {
                found = true;
                System.out.println("✅ KATEGORI UTAMA: " + category);
                if (!subcats.isEmpty()) {
                    System.out.println("   Subkategori:");
                    for (String sub : subcats) {
                        System.out.println("   • " + sub);
                    }
                }
                System.out.println();
            }

            for (String sub : subcats) {
                if (sub.toLowerCase().contains(keyword)) {
                    if (!found || !category.toLowerCase().contains(keyword)) {
                        found = true;
                        System.out.println("✅ SUBKATEGORI: " + sub);
                        System.out.println("   (dalam kategori: " + category + ")");
                        System.out.println();
                    }
                }
            }
        }

        if (!found) {
            System.out.println("❌ Tidak ditemukan kategori yang cocok dengan: \"" + keyword + "\"");
        }
    }

    private void changeCurrentLocation() {
        clearScreen();
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                  UBAH LOKASI SAAT INI                         ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");

        System.out.println("📍 Lokasi saat ini: " + currentLocation + "\n");
        System.out.println("Pilih lokasi baru:");

        List<String> locations = new ArrayList<>(library.getNodes().keySet());
        Collections.sort(locations);

        for (int i = 0; i < locations.size(); i++) {
            System.out.printf("   %2d. %s\n", (i + 1), locations.get(i));
        }

        System.out.print("\nPilih nomor lokasi: ");
        String input = scanner.nextLine().trim();

        try {
            int choice = Integer.parseInt(input);
            if (choice > 0 && choice <= locations.size()) {
                currentLocation = locations.get(choice - 1);
                System.out.println("\n✅ Lokasi berhasil diubah ke: " + currentLocation);
            } else {
                System.out.println("\n❌ Nomor tidak valid!");
            }
        } catch (NumberFormatException e) {
            System.out.println("\n❌ Input tidak valid!");
        }
    }

    private String parseDestination(String input, List<String> categories) {
        try {
            int index = Integer.parseInt(input);
            if (index > 0 && index <= categories.size()) {
                return categories.get(index - 1);
            }
        } catch (NumberFormatException e) {
            for (String cat : categories) {
                if (cat.equalsIgnoreCase(input)) {
                    return cat;
                }
            }
        }
        return null;
    }

    private void displayPathResult(List<String> path, String destination, String algorithm, double executionTime) {
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.println("              HASIL NAVIGASI (" + algorithm + ")");
        System.out.println("═══════════════════════════════════════════════════════════════\n");

        if (path != null && !path.isEmpty()) {
            System.out.println("✅ JALUR DITEMUKAN!\n");
            System.out.println("📍 Dari        : " + currentLocation);
            System.out.println("🎯 Ke          : " + destination);
            System.out.println("📊 Jumlah Langkah : " + (path.size() - 1));
            System.out.println("⏱  Waktu Eksekusi: " + String.format("%.4f", executionTime) + " ms\n");

            System.out.println("🗺  JALUR YANG HARUS DILALUI:");
            System.out.println("─────────────────────────────────────────────────────────────");

            for (int i = 0; i < path.size(); i++) {
                String node = path.get(i);
                if (i == 0) {
                    System.out.println("   🚩 START: " + node);
                } else if (i == path.size() - 1) {
                    System.out.println("   🏁 END  : " + node);
                } else {
                    System.out.println("   " + i + ". " + node);
                }

                if (i < path.size() - 1) {
                    System.out.println("      ↓");
                }
            }

            System.out.println("\n─────────────────────────────────────────────────────────────");
            System.out.println("💡 Rute singkat: " + String.join(" → ", path));
        } else {
            System.out.println("❌ JALUR TIDAK DITEMUKAN!");
        }

        System.out.println("\n═══════════════════════════════════════════════════════════════");
    }

    private void displayGoodbye() {
        clearScreen();
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                               ║");
        System.out.println("║              Terima Kasih Telah Menggunakan                   ║");
        System.out.println("║          Sistem Navigasi Perpustakaan Digital                 ║");
        System.out.println("║                                                               ║");
        System.out.println("║                  Sampai Jumpa Lagi! 👋                       ║");
        System.out.println("║                                                               ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");
    }

    private void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Main system = new Main();
        system.run();
    }
}