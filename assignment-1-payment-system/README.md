## Payment System - SOLID Principles

Bu projede basit bir ödeme sistemi geliştirilmiştir.

### Kullanılan SOLID Prensipleri

- SRP (Single Responsibility):
  Her ödeme sınıfı sadece kendi ödeme işlemini yapar.

- OCP (Open/Closed):
  Yeni ödeme yöntemi eklemek için mevcut kod değiştirilmemiştir.
  Sadece yeni bir sınıf eklenmiştir (PayPalPayment).

- DIP (Dependency Inversion):
  PaymentService somut sınıflara değil, PaymentMethod interface’ine bağımlıdır.

### Çalıştırma

Main.java çalıştırılarak örnek ödeme akışı görebilirsiniz.