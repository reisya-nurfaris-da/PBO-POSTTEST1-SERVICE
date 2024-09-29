<h1 align="center">Program Manajemen Servis Elektronik Sederhana</h1>

## TOC
- [Structure](#structure)
- [Flow](#flow)
- [Running](#running)
- [Usage Examples](#usage-examples)

## Structure
- service
  - [`Service.java`](./service/Service.java): logika utama program (interface, navigasi menu, operasi CRUD)
- model
  - [`RepairSchedule.java`](./model/RepairSchedule.java): Class yang isinya jadwal servis (informasi tentang pelanggan, perangkat, dan tanggal servis)
  - [`Technician.java`](./model/Technician.java): Class yang isinya teknisi yang tersedia untuk servis
  - [`SparePart.java`](./model/SparePart.java): Class yang isinya sparepart yang tersedia

## Flow
1. Pas buka program, user langsung lihat menu utama buat ngatur jadwal servis, teknisi, atau sparepart.
2. User tinggal pilih kategori yang mau diurus, terus nanti muncul sub-menu buat liat, nambah, ngedit, atau hapus data.
3. Habis selesai, user bisa balik ke menu utama atau keluar dari aplikasinya.

## Running
Tinggal di-run pake IDE/editor terserah apa aja yang penting bisa buka project java dan ada compiler+debugger-nya. Ini pake VSC soalnya lebih enak aja. 

Nanti yang jalan itu otomatis `mainClass` yang dideklarasi di `pom.xml` (`Service.java`)

![image](https://github.com/user-attachments/assets/74729a6b-0226-4483-b62d-e5d69b77ae16)

## Usage Examples
contoh di kategori jadwal servis (class RepairSchedule). Untuk kategori lainnya sama aja, cuma beda input.

### 1. Read
![image](https://github.com/user-attachments/assets/83e6cee7-343f-4b26-b290-024464b1d582)

### 2. Create
![image](https://github.com/user-attachments/assets/77f54af2-18dc-4bb3-9689-f78d33dac8e0)

### 3. Update
![image](https://github.com/user-attachments/assets/2c171a28-a5ff-4373-99bd-991d7dfd2a8b)

### 4. Delete
![image](https://github.com/user-attachments/assets/2aaef5ba-3383-4603-8ecb-acbe4cdb5152)
