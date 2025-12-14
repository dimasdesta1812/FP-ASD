# 📘 Final Project Algoritma dan Struktur Data

---

## 🧾 Informasi Umum (Cover)

* **Judul Proyek** : Bookstore Navigation
* **Mata Kuliah** : Algoritma dan Struktur Data
* **Kelas** : D
* **Nomor Kelompok** : 5
* **Dosen Pengampu** : Renny Pradina Kusumawardani

### 👥 Anggota Kelompok

| No | Nama               | NRP / NIM  |
| -- | ------------------ | ---------- |
| 1  | Dimas Ananda       | 5026241113 |
| 2  | Avissa Riyandita P | 5026241190 |
| 3  | Izzana Firdaunnisa | 5026241203 |

---

## 📌 Deskripsi Proyek

### 1. Latar Belakang

Gramedia merupakan pusat perbelanjaan literatur dan informasi yang menawarkan puluhan ribu judul buku dari beragam kategori. Namun, luasnya area toko, banyaknya lorong, serta minimnya petunjuk lokasi membuat pengunjung sering mengalami kesulitan dalam menemukan rak atau kategori buku yang dibutuhkan. Pengunjung harus menelusuri lorong satu per satu atau bertanya kepada petugas, yang tentunya kurang efisien dan memakan waktu.

Permasalahan ini menunjukkan perlunya sebuah sistem yang mampu membantu pengunjung menavigasi toko buku secara terstruktur dan sistematis, sehingga pencarian kategori buku dapat dilakukan dengan lebih cepat dan akurat.

### 2. Solusi yang Ditawarkan

Program **Bookstore Navigation** menawarkan solusi berupa sistem navigasi berbasis **graf (graph)** yang memodelkan setiap kategori buku sebagai node dan hubungan antar kategori sebagai edge. Dengan memanfaatkan algoritma pencarian jalur seperti **Breadth First Search (BFS)** dan **Dijkstra**, program dapat membantu pengguna menemukan rute tercepat atau terpendek menuju kategori buku yang diinginkan secara efisien.

Program **Bookstore Navigation** dikembangkan untuk membantu pengguna menavigasi kategori dan subkategori buku di dalam toko buku menggunakan konsep **graf**. Setiap kategori direpresentasikan sebagai node, dan hubungan antar kategori direpresentasikan sebagai edge. Dengan pendekatan algoritma graf, program dapat menampilkan struktur kategori serta rute navigasi yang jelas dan mudah dipahami.

---

## ⚙️ Fitur Program

* Menampilkan kategori utama dan subkategori buku di dalam toko
* Menentukan rute navigasi dari pintu masuk (GATE) ke kategori buku tujuan
* Menampilkan jalur pencarian berdasarkan algoritma BFS
* Menyediakan informasi langkah pencarian dan jarak tempuh kategori

---

## 🧠 Algoritma dan Struktur Data yang Digunakan

### 1. Graph (Graf)

* **Fungsi** : Merepresentasikan struktur toko buku dalam bentuk node dan edge
* **Digunakan pada fitur** : Navigasi kategori dan pemodelan lorong
* **Lokasi Implementasi** : `LibraryGraph.java`, `Node.java`

### 2. Breadth First Search (BFS)

* **Fungsi** : Mencari jalur tercepat berdasarkan jumlah langkah (level)
* **Digunakan pada fitur** : Navigasi dari kategori awal ke kategori tujuan
* **Lokasi Implementasi** : `LibraryGraph.java`

### 3. Dijkstra Algorithm

* **Fungsi** : Mencari jalur terpendek berdasarkan bobot jarak antar kategori
* **Digunakan pada fitur** : Penentuan jalur optimal dengan bobot
* **Lokasi Implementasi** : `LibraryGraph.java`

### 4. Struktur Data Pendukung

* **ArrayList** : Menyimpan daftar jalur dan tetangga node
* **HashMap** : Menyimpan node graph dan bobot antar node
* **Queue** : Digunakan pada proses BFS

---

## 📂 Deskripsi File dan Class Program

### **Main.java**

* **Deskripsi** : Class utama program
* **Fungsi Utama** : Menampilkan menu, menerima input pengguna, dan menjalankan fitur navigasi

### **LibraryGraph.java**

* **Deskripsi** : Mengelola struktur graf kategori buku
* **Struktur Data yang Digunakan** : Graph, HashMap, ArrayList
* **Fungsi Utama** : Menambahkan node, menghubungkan kategori, menampilkan kategori, dan mencari rute navigasi

### **Node.java**

* **Deskripsi** : Merepresentasikan satu kategori buku
* **Atribut Utama** : Nama kategori, daftar tetangga, penanda kategori utama

### **NavigationDirection.java**

* **Deskripsi** : Mengatur dan menampilkan instruksi arah navigasi
* **Fungsi Utama** : Menyajikan petunjuk arah dalam bentuk teks dan simbol panah

---

## 🗂️ Struktur Folder Repository

```
FP-ASD/
│── Kode/
│   ├── Main.java
│   ├── LibraryGraph.java
│   ├── Node.java
│   ├── NavigationDirection.java
│
│── Presentasi/
│   ├── ASD 5_Bookstore Navigation.pdf
│
│── README.md
```

---

## 🖥️ Screenshot Program

* Main Menu
  ![Main Menu](<img width="928" height="655" alt="image" src="https://github.com/user-attachments/assets/9c2839f9-bbf8-437f-968f-405434b61698" />)
  
* Fitur
  ![Fitur](<img width="843" height="518" alt="image" src="https://github.com/user-attachments/assets/4b3f6cfb-08d4-4a4c-9c80-8812de97a95d" />)

* Fitur 1
  ![Fitur 1](<img width="808" height="717" alt="image" src="https://github.com/user-attachments/assets/47d4841e-9c82-4cbe-b950-c6c00415f43b" />)

* Fitur 2
  ![Fitur 2](<img width="1053" height="751" alt="image" src="https://github.com/user-attachments/assets/6685892e-2572-46e5-bf4d-9f60466e2b37" />)
  
* Fitur 3
   ![Fitur 3](<img width="884" height="750" alt="image" src="https://github.com/user-attachments/assets/04c2bbcf-5fc2-4c0f-8d15-9ee10b7374ef" />)
  
* Fitur 4
   ![Fitur 4](<img width="883" height="611" alt="image" src="https://github.com/user-attachments/assets/4f7d8fd7-d0d4-4134-a755-fc2825d979e0" />)
  
* Fitur 5
   ![Fitur 5](<img width="548" height="730" alt="image" src="https://github.com/user-attachments/assets/9385ce67-de7c-4b3e-b6fe-2b123177d0d8" />)
  
* Fitur 6
   ![Fitur 6](<img width="851" height="562" alt="image" src="https://github.com/user-attachments/assets/816f8e21-2bbd-4375-921c-fcc69720db2b" />)

---

## 🔄 Riwayat Update Program

* **Tanggal Update** : 11 Desember 2025
* **Deskripsi Update** : Implementasi struktur graf dan navigasi kategori
* **File yang Diubah** : `LibraryGraph.java`, `Main.java`
* 
---

## 🔗 Referensi Proyek Kelompok Lain

1. D-1 : Word Rank Guesser Game
Link : https://github.com/NashiwaInsan/asdfinalproject

2. D-2 : Sistem Rekomendasi Event Berbasis Graph
Link : https://github.com/dedyirama-id/kael-recommendation-system

3. D-3 : Smart Traffic Light Simulator
Link : https://github.com/Sudukk/FP_ASD_Traffic_Light_Simulation_FINAL

4. D-4 : HotelSeek - Rekomendasi Pemilihan Hotel
Link : https://github.com/dreadf/hotelseek

5. D-6 : To-Do List
Link : https://github.com/anggraitapr/ASDFPTODOLIST

6. D-7 : Sistem Antrian IGD
Link : https://github.com/WilliamHanantha/FP-ASD

7. D-8 : Sistem Rekomendasi Jadwal Latihan dan Nutrisi Gym
Link :https://github.com/tyr3x74/GymPlan

8. D-9 : Sistem Rekomendasi Teman Berdasarkan Mutual Friends
Link :https://github.com/mariaelvina/FinalProjectD9

9. D-10 : Monster Chase
Link : https://github.com/Aida41104/FPASD

10. D-11 : Warehouse Management System
Link : https://github.com/FasaBil/ASD-D11-Inventory-Management

11. D-12 : Smart Traveling Planner
Link : https://github.com/Dziky05/FP-ASD-KEL-13

12. D-13 : Sistem Manajemen Inventaris Gudang dan Optimasi Rute Pengiriman
Link : https://github.com/FashaAsshofa/Final-Project-ASD-D-Kelompok-13

13. D-14 : Rekomendasi Film berbasis Graph
Link : https://github.com/neutralcheeze/final-project-asd.git

---
