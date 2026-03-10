/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chapter03;

import java.util.concurrent.CompletableFuture;

public class Bai3 {
    public static void main(String[] args) {

        // Tác vụ 1: Xác thực khách hàng
        CompletableFuture<String> xacThuc = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000); // giả lập thời gian xử lý
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Xác thực khách hàng hoàn thành");
            return "Khách hàng hợp lệ";
        });

        // Tác vụ 2: Xuất vé
        CompletableFuture<String> xuatVe = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000); // giả lập thời gian xử lý
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Xuất vé xem phim hoàn thành");
            return "Vé đã được xuất";
        });

        // Kết hợp 2 tác vụ
        CompletableFuture<String> ketQua = xacThuc.thenCombine(xuatVe, (a, b) -> {
            return a + " | " + b;
        });

        // In kết quả cuối
        System.out.println("Kết quả hệ thống: " + ketQua.join());
    }
}
