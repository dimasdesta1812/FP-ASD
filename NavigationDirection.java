import java.util.*;

public class NavigationDirection {

    public static class DirectionInstruction {
        String from;
        String to;
        double distance;
        String direction;
        String arrow;
        double angle;

        public DirectionInstruction(String from, String to, double distance,
                                    String direction, String arrow, double angle) {
            this.from = from;
            this.to = to;
            this.distance = distance;
            this.direction = direction;
            this.arrow = arrow;
            this.angle = angle;
        }
    }

    // Hitung jarak antara dua node
    public static double calculateDistance(Node n1, Node n2) {
        int dx = n2.x - n1.x;
        int dy = n2.y - n1.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Hitung sudut dalam derajat (0-360)
    public static double calculateAngle(Node from, Node to) {
        int dx = to.x - from.x;
        int dy = from.y - to.y; // Y terbalik karena koordinat layar
        double angle = Math.toDegrees(Math.atan2(dy, dx));
        if (angle < 0) angle += 360;
        return angle;
    }

    // Hitung perbedaan sudut untuk menentukan arah belok
    public static double getAngleDifference(double angle1, double angle2) {
        double diff = angle2 - angle1;
        while (diff > 180) diff -= 360;
        while (diff < -180) diff += 360;
        return diff;
    }

    // Konversi sudut ke arah panah
    public static String getArrowFromAngle(double angle) {
        if (angle >= 337.5 || angle < 22.5) return "➡";  // Kanan
        if (angle >= 22.5 && angle < 67.5) return "↗";   // Kanan atas
        if (angle >= 67.5 && angle < 112.5) return "⬆";  // Atas
        if (angle >= 112.5 && angle < 157.5) return "↖"; // Kiri atas
        if (angle >= 157.5 && angle < 202.5) return "⬅"; // Kiri
        if (angle >= 202.5 && angle < 247.5) return "↙"; // Kiri bawah
        if (angle >= 247.5 && angle < 292.5) return "⬇"; // Bawah
        return "↘"; // Kanan bawah
    }

    // Dapatkan instruksi belok berdasarkan perbedaan sudut
    public static String getTurnInstruction(double angleDiff) {
        double absAngle = Math.abs(angleDiff);

        if (absAngle < 15) {
            return "Lurus";
        } else if (absAngle < 45) {
            return angleDiff > 0 ? "Belok sedikit ke kiri" : "Belok sedikit ke kanan";
        } else if (absAngle < 80) {
            return angleDiff > 0 ? "Belok kiri" : "Belok kanan";
        } else if (absAngle < 100) {
            return angleDiff > 0 ? "Belok kiri 90°" : "Belok kanan 90°";
        } else if (absAngle < 135) {
            return angleDiff > 0 ? "Belok tajam ke kiri" : "Belok tajam ke kanan";
        } else {
            return "Putar balik";
        }
    }

    // Generate instruksi navigasi lengkap dari path
    public static List<DirectionInstruction> generateInstructions(List<String> path, Map<String, Node> nodes) {
        List<DirectionInstruction> instructions = new ArrayList<>();

        if (path == null || path.size() < 2) {
            return instructions;
        }

        double previousAngle = 0;

        for (int i = 0; i < path.size() - 1; i++) {
            Node currentNode = nodes.get(path.get(i));
            Node nextNode = nodes.get(path.get(i + 1));

            double distance = calculateDistance(currentNode, nextNode);
            double angle = calculateAngle(currentNode, nextNode);
            String arrow = getArrowFromAngle(angle);
            String direction;

            if (i == 0) {
                // Instruksi pertama
                direction = "Mulai berjalan";
            } else {
                // Hitung arah belok
                double angleDiff = getAngleDifference(previousAngle, angle);
                direction = getTurnInstruction(angleDiff);
            }

            instructions.add(new DirectionInstruction(
                    path.get(i),
                    path.get(i + 1),
                    distance,
                    direction,
                    arrow,
                    angle
            ));

            previousAngle = angle;
        }

        return instructions;
    }

    // Display instruksi navigasi dengan format bagus
    public static void displayNavigationInstructions(List<DirectionInstruction> instructions,
                                                     String startLocation, String endLocation) {
        if (instructions.isEmpty()) {
            System.out.println("❌ Tidak ada instruksi navigasi tersedia.");
            return;
        }

        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║              INSTRUKSI NAVIGASI TURN-BY-TURN                  ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");

        System.out.println("🚩 Mulai dari: " + startLocation);
        System.out.println("🎯 Tujuan: " + endLocation);
        System.out.println("\n📍 Instruksi:\n");

        // Tampilkan setiap instruksi
        for (int i = 0; i < instructions.size(); i++) {
            DirectionInstruction inst = instructions.get(i);
            System.out.printf("   %d. %s %s → %s\n",
                    i + 1, inst.arrow, inst.direction, inst.to);
        }

        System.out.println("\n🏁 Sampai di tujuan!");
        System.out.println("═════════════════════════════════════════════════════════════");
    }

    // Display versi compact (untuk quick view)
    public static void displayCompactInstructions(List<DirectionInstruction> instructions) {
        if (instructions.isEmpty()) return;

        System.out.println("\n🗺  RUTE SINGKAT:");
        System.out.println("─────────────────────────────────────────────────────────────");

        for (int i = 0; i < instructions.size(); i++) {
            DirectionInstruction inst = instructions.get(i);
            System.out.printf("   %s %s → %s\n",
                    inst.arrow, inst.direction, inst.to);
        }
        System.out.println("─────────────────────────────────────────────────────────────");
    }
}