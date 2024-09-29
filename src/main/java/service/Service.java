package service;

import java.util.ArrayList;
import java.util.Scanner;

import model.RepairSchedule;
import model.SparePart;
import model.Technician;

public class Service {
    // deklarasi list
    static ArrayList<RepairSchedule> repairSchedules = new ArrayList<>();
    static ArrayList<Technician> technicians = new ArrayList<>();
    static ArrayList<SparePart> spareParts = new ArrayList<>();
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true; // flag buat berentiin loopnya
            
            // data untuk ngetest
            repairSchedules.add(new RepairSchedule("Ejo", "Laptop Asus TUF", "2024-09-29"));
            repairSchedules.add(new RepairSchedule("Krisna", "Hp Samsung", "2024-10-01"));
            repairSchedules.add(new RepairSchedule("Ninda", "Printer Canon Inkjet", "2024-10-05"));
            
            technicians.add(new Technician("Juno Nadianto"));
            technicians.add(new Technician("Farhan Pertama"));
            technicians.add(new Technician("Kiki Fernandi"));
            
            spareParts.add(new SparePart("SSD Sata 512GB", 5));
            spareParts.add(new SparePart("Baterai Samsung S21", 10));
            spareParts.add(new SparePart("Head Printer Canon", 2));
            
            // ================================= menu ================================= //

            // bagian yang jadi interface awal
            while (running) {
                System.out.println("\n=== Sistem Manajemen Servis Elektronik ===");
                System.out.println("[1] Jadwal Servis");
                System.out.println("[2] Teknisi");
                System.out.println("[3] Sparepart");
                System.out.println("[4] Keluar");
                System.out.print("Pilih kategori: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // clear buffer (ngilangin baris kosong supaya gak kepake jadi input)
                
                // pake switch case biar keliatan kompek aja
                switch (choice) {
                    case 1 -> manageRepairSchedule(scanner);
                    case 2 -> manageTechnicians(scanner);
                    case 3 -> manageSpareParts(scanner);
                    case 4 -> {
                        running = false;
                        System.out.println("Keluar dari sistem.");
                    }
                    default -> System.out.println("Opsi tidak valid. Coba lagi.");
                }
            }
        }
    }
    
    // menu jadwal servis
    static void manageRepairSchedule(Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Manajemen Jadwal Servis ---");
            System.out.println("[1] Tampilkan Semua Jadwal");
            System.out.println("[2] Tambah Jadwal");
            System.out.println("[3] Edit Jadwal");
            System.out.println("[4] Hapus Jadwal");
            System.out.println("[5] Kembali");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1 -> displayRepairSchedules();
                case 2 -> addRepairSchedule(scanner);
                case 3 -> editRepairSchedule(scanner);
                case 4 -> deleteRepairSchedule(scanner);
                case 5 -> back = true;
                default -> System.out.println("Opsi tidak valid.");
            }
        }
    }
    
    // menu teknisi
    static void manageTechnicians(Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Manajemen Teknisi ---");
            System.out.println("[1] Tampilkan Semua Teknisi");
            System.out.println("[2] Tambah Teknisi");
            System.out.println("[3] Edit Teknisi");
            System.out.println("[4] Hapus Teknisi");
            System.out.println("[5] Kembali");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1 -> displayTechnicians();
                case 2 -> addTechnician(scanner);
                case 3 -> editTechnician(scanner);
                case 4 -> deleteTechnician(scanner);
                case 5 -> back = true;
                default -> System.out.println("Opsi tidak valid.");
            }
        }
    }

    // menu sparepart
    static void manageSpareParts(Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Manajemen Sparepart ---");
            System.out.println("[1] Tampilkan Semua Sparepart");
            System.out.println("[2] Tambah Sparepart");
            System.out.println("[3] Edit Sparepart");
            System.out.println("[4] Hapus Sparepart");
            System.out.println("[5] Kembali");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1 -> displaySpareParts();
                case 2 -> addSparePart(scanner);
                case 3 -> editSparePart(scanner);
                case 4 -> deleteSparePart(scanner);
                case 5 -> back = true;
                default -> System.out.println("Opsi tidak valid.");
            }
        }
    }
    
    // ================================= crud ================================= //

    // create jadwal
    static void addRepairSchedule(Scanner scanner) {
        System.out.print("Masukkan nama pelanggan: ");
        String customerName = scanner.nextLine();
        System.out.print("Masukkan nama perangkat: ");
        String deviceName = scanner.nextLine();
        System.out.print("Masukkan tanggal servis (yyyy-mm-dd): ");
        String date = scanner.nextLine();
        repairSchedules.add(new RepairSchedule(customerName, deviceName, date));
        System.out.println("Jadwal servis berhasil ditambahkan.");
    }
    
    // read jadwal
    static void displayRepairSchedules() {
        System.out.println("\nDaftar Jadwal Servis:");
        for (RepairSchedule schedule : repairSchedules) {
            System.out.println(schedule);
        }
    }
    
    // update jadwal
    static void editRepairSchedule(Scanner scanner) {
        System.out.print("Masukkan ID jadwal yang ingin diedit: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        // nyari dari id
        RepairSchedule RepairScheduleToEdit = null;
        for (RepairSchedule sched : repairSchedules) {
            if (sched.getId() == id) {
                RepairScheduleToEdit = sched;
                break;
            }
        }

        if (RepairScheduleToEdit != null) {
            // masukin value baru
            System.out.print("Masukkan nama pelanggan baru (biarkan kosong jika tidak ingin diubah): ");
            String newCustomerName = scanner.nextLine();
            if (!newCustomerName.isEmpty()) { // artinya 'kalau newCustomerName gak empty'
                RepairScheduleToEdit.setCustomerName(newCustomerName); 
            }
            
            System.out.print("Masukkan nama perangkat baru (biarkan kosong jika tidak ingin diubah): ");
            String newDeviceName = scanner.nextLine();
            if (!newDeviceName.isEmpty()) {
                RepairScheduleToEdit.setDeviceName(newDeviceName); 
            }
            
            System.out.print("Masukkan tanggal servis baru (yyyy-mm-dd) (biarkan kosong jika tidak ingin diubah): ");
            String newDate = scanner.nextLine();
            if (!newDate.isEmpty()) {
                RepairScheduleToEdit.setDate(newDate);
            }

            System.out.println("Jadwal berhasil diupdate.");
        } else {
            System.out.println("Jadwal dengan ID tersebut tidak ditemukan.");
        }
    }
    
    // delete jadwal
    static void deleteRepairSchedule(Scanner scanner) {
        System.out.print("Masukkan ID jadwal yang ingin dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        RepairSchedule repairScheduleToDelete = null;
        for (RepairSchedule sched : repairSchedules) {
            if (sched.getId() == id) {
                repairScheduleToDelete = sched;
                break;
            }
        }

        if (repairScheduleToDelete != null) {
            repairSchedules.remove(repairScheduleToDelete);
            System.out.println("Jadwal berhasil dihapus.");
        } else {
            System.out.println("Jadwal dengan ID tersebut tidak ditemukan.");
        }
    }
    

    // create teknisi
    static void addTechnician(Scanner scanner) {
        System.out.print("Masukkan nama teknisi: ");
        String name = scanner.nextLine();
        technicians.add(new Technician(name));
        System.out.println("Teknisi berhasil ditambahkan.");
    }
    
    // read teknisi
    static void displayTechnicians() {
        System.out.println("\nDaftar Teknisi:");
        for (Technician tech : technicians) {
            System.out.println(tech);
        }
    }
    
    // update teknisi
    static void editTechnician(Scanner scanner) {
        System.out.print("Masukkan ID teknisi yang ingin diedit: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Technician technicianToEdit = null;
        for (Technician tech : technicians) {
            if (tech.getId() == id) {
                technicianToEdit = tech;
                break;
            }
        }

        if (technicianToEdit != null) {
            System.out.print("Masukkan nama sparepart baru (biarkan kosong jika tidak ingin diubah): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                technicianToEdit.setName(newName);
            }

            System.out.println("Teknisi berhasil diupdate.");
        } else {
            System.out.println("Teknisi dengan ID tersebut tidak ditemukan.");
        }
    }
    
    // delete teknisi
    static void deleteTechnician(Scanner scanner) {
        System.out.print("Masukkan ID teknisi yang ingin dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Technician technicianToDelete = null;
        for (Technician tech : technicians) {
            if (tech.getId() == id) {
                technicianToDelete = tech;
                break;
            }
        }

        if (technicianToDelete != null) {
            technicians.remove(technicianToDelete);
            System.out.println("Teknisi berhasil dihapus.");
        } else {
            System.out.println("Teknisi dengan ID tersebut tidak ditemukan.");
        }
    }

    
    // create sparepart
    static void addSparePart(Scanner scanner) {
        System.out.print("Masukkan nama sparepart: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan jumlah stok: ");
        int quantity = scanner.nextInt();
        spareParts.add(new SparePart(name, quantity));
        System.out.println("Sparepart berhasil ditambahkan.");
    }

    // read sparepart
    static void displaySpareParts() {
        System.out.println("\nDaftar Sparepart:");
        for (SparePart part : spareParts) {
            System.out.println(part);
        }
    }
    
    // update sparepart
    static void editSparePart(Scanner scanner) {
        System.out.print("Masukkan ID sparepart yang ingin diedit: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        
        SparePart sparePartToEdit = null;
        for (SparePart part : spareParts) {
            if (part.getId() == id) {
                sparePartToEdit = part;
                break;
            }
        }

        if (sparePartToEdit != null) {
            System.out.print("Masukkan nama sparepart baru (biarkan kosong jika tidak ingin diubah): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                sparePartToEdit.setName(newName);  
            }

            System.out.print("Masukkan jumlah stok baru (biarkan kosong jika tidak ingin diubah): ");
            String newQuantityInput = scanner.nextLine(); // pake string biar bisa dikosongin, kalo pake int malah nunggu angka terus
            if (!newQuantityInput.isEmpty()) {
                int newQuantity = Integer.parseInt(newQuantityInput);  // convert  jadi integer 
                sparePartToEdit.setQuantity(newQuantity); 
            }

            System.out.println("Sparepart berhasil diupdate.");
        } else {
            System.out.println("Sparepart dengan ID tersebut tidak ditemukan.");
        }
    }

    // delete sparepart
    static void deleteSparePart(Scanner scanner) {
        System.out.print("Masukkan ID sparepart yang ingin dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        
        SparePart sparePartToDelete = null;
        for (SparePart part : spareParts) {
            if (part.getId() == id) {
                sparePartToDelete = part;
                break;
            }
        }

        if (sparePartToDelete != null) {
            spareParts.remove(sparePartToDelete);
            System.out.println("Sparepart berhasil dihapus.");
        } else {
            System.out.println("Sparepart dengan ID tersebut tidak ditemukan.");
        }
    }
}
