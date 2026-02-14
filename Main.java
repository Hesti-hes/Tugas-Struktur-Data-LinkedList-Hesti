class Node {
    String nim;
    String nama;
    Node next;

    Node(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        this.next = null;
    }
}

public class Main {
    static Node head = null;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        System.out.println("=================================================");
        System.out.println("          TUGAS STRUKTUR DATA - LINKEDLIST       ");
        System.out.println("=================================================");
        System.out.println(" Nama    : Hesti Febriyani");
        System.out.println(" Kelas   : Informatika A");
        System.out.println(" NIM     : 24106050010");
        System.out.println(" Matkul  : Struktur Data");
        System.out.println("=================================================");
        
        int pilihan = 0;
        while (pilihan != 9) {
            System.out.println("\n=== MENU LINKEDLIST (Count: " + count + ") ===");
            System.out.println("1. Insert Beginning    4. Delete Beginning    7. Delete First Occurrence");
            System.out.println("2. Insert Position     5. Delete Position     8. Show Data");
            System.out.println("3. Insert End          6. Delete End          9. Exit");
            System.out.print("Pilih menu: ");
            
            pilihan = readInt();

            if (pilihan == 1) { // 1. Insert Beginning
                System.out.print("Masukkan NIM : "); String nim = readString();
                System.out.print("Masukkan Nama: "); String nama = readString();
                Node newNode = new Node(nim, nama);
                newNode.next = head;
                head = newNode;
                count++;
                System.out.println("Data berhasil ditambahkan di awal.");
            } 
            else if (pilihan == 2) { // 2. Insert Position
                System.out.print("Masukkan NIM : "); String nim = readString();
                System.out.print("Masukkan Nama: "); String nama = readString();
                System.out.print("Masukkan posisi (1-" + (count + 1) + "): ");
                int pos = readInt();
                if (pos == 1) {
                    Node newNode = new Node(nim, nama);
                    newNode.next = head;
                    head = newNode;
                    count++;
                    System.out.println("Data berhasil ditambahkan di posisi " + pos + ".");
                } else if (pos > 1 && pos <= count + 1) {
                    Node newNode = new Node(nim, nama);
                    Node temp = head;
                    for (int i = 1; i < pos - 1; i++) temp = temp.next;
                    newNode.next = temp.next;
                    temp.next = newNode;
                    count++;
                    System.out.println("Data berhasil ditambahkan di posisi " + pos + ".");
                } else System.out.println("Posisi tidak valid!");
            } 
            else if (pilihan == 3) { // 3. Insert End
                System.out.print("Masukkan NIM : "); String nim = readString();
                System.out.print("Masukkan Nama: "); String nama = readString();
                Node newNode = new Node(nim, nama);
                if (head == null) {
                    head = newNode;
                } else {
                    Node temp = head;
                    while (temp.next != null) temp = temp.next;
                    temp.next = newNode;
                }
                count++;
                System.out.println("Data berhasil ditambahkan di akhir.");
            } 
            else if (pilihan == 4) { // 4. Delete Beginning
                if (head != null) { 
                    head = head.next; 
                    count--; 
                    System.out.println("Data awal berhasil dihapus.");
                }
                else System.out.println("Data kosong.");
            } 
            else if (pilihan == 5) { // 5. Delete Position
                if (head == null) { System.out.println("Data kosong."); }
                else {
                    System.out.print("Masukkan posisi (1-" + count + "): ");
                    int pos = readInt();
                    if (pos == 1) { 
                        head = head.next; count--; 
                        System.out.println("Data posisi " + pos + " berhasil dihapus.");
                    }
                    else if (pos > 1 && pos <= count) {
                        Node temp = head;
                        for (int i = 1; i < pos - 1; i++) temp = temp.next;
                        temp.next = temp.next.next;
                        count--;
                        System.out.println("Data posisi " + pos + " berhasil dihapus.");
                    } else System.out.println("Posisi tidak valid!");
                }
            } 
            else if (pilihan == 6) { // 6. Delete End
                if (head != null) {
                    if (head.next == null) head = null;
                    else {
                        Node temp = head;
                        while (temp.next.next != null) temp = temp.next;
                        temp.next = null;
                    }
                    count--;
                    System.out.println("Data terakhir berhasil dihapus.");
                } else System.out.println("Data kosong.");
            } 
            else if (pilihan == 7) { // 7. Delete By NIM
                if (head == null) { System.out.println("Data kosong."); }
                else {
                    System.out.print("Masukkan NIM yang akan dihapus: ");
                    String sNim = readString();
                    if (head.nim.equals(sNim)) { 
                        head = head.next; count--; 
                        System.out.println("Data NIM " + sNim + " berhasil dihapus.");
                    }
                    else {
                        Node temp = head;
                        while (temp.next != null && !temp.next.nim.equals(sNim)) temp = temp.next;
                        if (temp.next != null) { 
                            temp.next = temp.next.next; count--; 
                            System.out.println("Data NIM " + sNim + " berhasil dihapus.");
                        }
                        else System.out.println("NIM tidak ditemukan!");
                    }
                }
            } 
            else if (pilihan == 8) { // 8. Show Data
                System.out.println("\n--- DAFTAR DATA MAHASISWA ---");
                Node temp = head;
                int i = 1;
                while (temp != null) {
                    System.out.println(i + ". NIM: " + temp.nim + " | Nama: " + temp.nama);
                    temp = temp.next;
                    i++;
                }
                if (head == null) System.out.println("Data masih kosong.");
            } 
            else if (pilihan == 9) { // 9. Exit
                System.out.println("Selesai! Terima kasih Pak Nurochman.");
            }
        }
    }

    static String readString() throws Exception {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = System.in.read()) != '\n' && c != -1) {
            if (c != '\r') sb.append((char) c);
        }
        return sb.toString();
    }

    static int readInt() throws Exception {
        String s = readString();
        try { return Integer.parseInt(s); } catch (Exception e) { return 0; }
    }
}