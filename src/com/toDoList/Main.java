package com.toDoList;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
  ArrayList<String> tasks = new ArrayList<String>();
  Scanner scanner = new Scanner(System.in);
  int choice;

  do {
   System.out.println("Pilih menu: ");
   System.out.println("1. Tambah tugas");
   System.out.println("2. Tampilkan tugas yang harus diselesaikan");
   System.out.println("3. Hapus tugas yang sudah diselesaikan");
   System.out.println("4. Tampilkan seluruh isi to-do list");
   System.out.println("5. Keluar");

   choice = scanner.nextInt();

   switch (choice) {
    case 1:
     System.out.print("Masukkan nama tugas: ");
     scanner.nextLine();
     String task = scanner.nextLine();
     tasks.add(task);
     System.out.println("Tugas \"" + task + "\" telah ditambahkan ke dalam to-do list.");
     break;
    case 2:
     if (tasks.isEmpty()) {
      System.out.println("To-do list kosong.");
     } else {
      System.out.println("Tugas yang harus diselesaikan: " + tasks.get(0));
     }
     break;
    case 3:
     if (tasks.isEmpty()) {
      System.out.println("To-do list kosong.");
     } else {
      String taskCompleted = tasks.remove(0);
      System.out.println("Tugas \"" + taskCompleted + "\" telah dihapus dari to-do list.");
     }
     break;
    case 4:
     if (tasks.isEmpty()) {
      System.out.println("To-do list kosong.");
     } else {
      System.out.println("Isi to-do list:");
      for (String taskItem : tasks) {
       System.out.println("- " + taskItem);
      }
     }
     break;
    case 5:
     System.out.println("Keluar dari program.");
     break;
    default:
     System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
     break;
   }

   System.out.println();

  } while (choice != 5);

  scanner.close();
 }
}
