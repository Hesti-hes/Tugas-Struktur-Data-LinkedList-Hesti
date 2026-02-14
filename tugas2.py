class Node:
    def __init__(self, nim, nama):
        self.nim = nim
        self.nama = nama
        self.next = None

head = None
count = 0

print("\n=================================================")
print("          TUGAS STRUKTUR DATA - LINKEDLIST       ")
print("=================================================")
print(" Nama    : Hesti Febriyani")
print(" Kelas   : Informatika A")
print(" NIM     : 24106050010")
print(" Matkul  : Struktur Data")
print("=================================================")

while True:
    print(f"\n=== MENU LINKEDLIST (Count: {count}) ===")
    print("1. Insert Beginning    4. Delete Beginning    7. Delete First Occurrence")
    print("2. Insert Position     5. Delete Position     8. Show Data")
    print("3. Insert End          6. Delete End          9. Exit")
    
    pilihan = input("Pilih menu: ")

    if pilihan == '1':
        nim = input("Masukkan NIM : ")
        nama = input("Masukkan Nama: ")
        new_node = Node(nim, nama)
        new_node.next = head
        head = new_node
        count += 1
        print("Data berhasil ditambahkan di awal.")

    elif pilihan == '2':
        nim = input("Masukkan NIM : ")
        nama = input("Masukkan Nama: ")
        pos = int(input(f"Posisi (1-{count+1}): "))
        new_node = Node(nim, nama)
        if pos == 1:
            new_node.next = head
            head = new_node
            count += 1
            print(f"Data berhasil ditambahkan di posisi {pos}.")
        elif 1 < pos <= count + 1:
            temp = head
            for _ in range(pos - 2): temp = temp.next
            new_node.next = temp.next
            temp.next = new_node
            count += 1
            print(f"Data berhasil ditambahkan di posisi {pos}.")
        else: print("Posisi tidak valid!")

    elif pilihan == '3':
        nim = input("Masukkan NIM : ")
        nama = input("Masukkan Nama: ")
        new_node = Node(nim, nama)
        if not head:
            head = new_node
        else:
            temp = head
            while temp.next: temp = temp.next
            temp.next = new_node
        count += 1
        print("Data berhasil ditambahkan di akhir.")

    elif pilihan == '4':
        if head:
            head = head.next
            count -= 1
            print("Data awal berhasil dihapus.")
        else: print("Data kosong.")

    elif pilihan == '5':
        if head:
            pos = int(input(f"Posisi (1-{count}): "))
            if pos == 1:
                head = head.next
                count -= 1
                print(f"Data posisi {pos} berhasil dihapus.")
            elif 1 < pos <= count:
                temp = head
                for _ in range(pos - 2): temp = temp.next
                temp.next = temp.next.next
                count -= 1
                print(f"Data posisi {pos} berhasil dihapus.")
            else: print("Posisi tidak valid!")
        else: print("Data kosong.")

    elif pilihan == '6':
        if head:
            if not head.next: head = None
            else:
                temp = head
                while temp.next.next: temp = temp.next
                temp.next = None
            count -= 1
            print("Data terakhir berhasil dihapus.")
        else: print("Data kosong.")

    elif pilihan == '7':
        if head:
            s_nim = input("Masukkan NIM yang ingin dihapus: ")
            if head.nim == s_nim:
                head = head.next
                count -= 1
                print(f"Data NIM {s_nim} berhasil dihapus.")
            else:
                temp = head
                while temp.next and temp.next.nim != s_nim: temp = temp.next
                if temp.next:
                    temp.next = temp.next.next
                    count -= 1
                    print(f"Data NIM {s_nim} berhasil dihapus.")
                else: print("NIM tidak ditemukan!")
        else: print("Data kosong.")

    elif pilihan == '8':
        print("\n--- DAFTAR DATA MAHASISWA ---")
        temp = head
        i = 1
        while temp:
            print(f"{i}. NIM: {temp.nim} | Nama: {temp.nama}")
            temp = temp.next
            i += 1
        if not head: print("Data masih kosong.")

    elif pilihan == '9':
        print("Selesai! Terima kasih Pak Nurochman.")
        break