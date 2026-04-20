# Payment System - SOLID & Reflection

Bu projede basit bir ödeme sistemi geliştirilmiştir. Sistem, farklı ödeme yöntemlerini destekleyecek şekilde esnek, genişletilebilir ve SOLID prensiplerine uygun olarak tasarlanmıştır.

---

##  Proje Amacı

Mevcut ödeme sistemine yeni bir ödeme yöntemi eklenmesi senaryosu üzerinden:

- Sistemi bozmadan genişletme (OCP)
- Sınıfların tek sorumluluğa sahip olması (SRP)
- Soyutlamaya bağımlı tasarım (DIP)
- Reflection kullanımı ile dinamik nesne oluşturma

amaçlanmıştır.

---

##  Sistem Tasarımı

Sistemde tüm ödeme yöntemleri `PaymentMethod` interface’ini implement eder.  
Ödeme işlemleri `PaymentService` üzerinden gerçekleştirilir.

Kullanıcıdan alınan ödeme yöntemi adına göre ilgili sınıf **runtime’da (çalışma anında)** Reflection kullanılarak oluşturulur.

---

##  Kullanılan Yapılar

- Java
- OOP (Object-Oriented Programming)
- SOLID Prensipleri
- Java Reflection API

---

##  SOLID Prensipleri

### SRP (Single Responsibility Principle)

Her sınıf tek bir sorumluluğa sahiptir:

- `CreditCardPayment` → kredi kartı ile ödeme yapar
- `PayPalPayment` → PayPal ile ödeme yapar
- `GooglePayPayment` → Google Pay ile ödeme yapar
- `PaymentService` → ödeme sürecini yönetir
- `PaymentFactory` → ödeme nesnesi oluşturur

---

### OCP (Open/Closed Principle)

Sistem genişlemeye açıktır, değişime kapalıdır.

Yeni bir ödeme yöntemi eklemek için:
- Mevcut kodlar değiştirilmez
- Sadece `PaymentMethod` interface’ini implement eden yeni bir sınıf eklenir

---

### DIP (Dependency Inversion Principle)

`PaymentService`, somut sınıflara değil abstraction olan `PaymentMethod` interface’ine bağımlıdır.

Bu sayede farklı ödeme yöntemleri kolayca sisteme entegre edilebilir.

---

##  Reflection Kullanımı

Ödeme yöntemi nesneleri doğrudan `new` anahtar kelimesi ile oluşturulmamıştır.

Bunun yerine:

- Kullanıcıdan alınan sınıf adı kullanılır
- `Class.forName(...)` ile ilgili sınıf yüklenir
- `getDeclaredConstructor().newInstance()` ile Reflection kullanılarak nesne oluşturulur

Bu sayede sistem, yeni eklenen sınıfları önceden bilmeden çalışma anında (runtime) oluşturabilir.

---

## ️ Çalıştırma

1. Uygulamayı çalıştırın (`Main.java`)
2. Konsolda listelenen ödeme yöntemlerinden birini girin  
   (Örnek: `CreditCardPayment`, `PayPalPayment`)
3. Ödeme tutarını girin
4. Ödeme işlemi gerçekleştirilir

---

## ➕ Genişletilebilirlik

Yeni bir ödeme yöntemi eklemek için:

1. `PaymentMethod` interface’ini implement eden yeni bir sınıf oluşturun

```java
public class ApplePayPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println(amount + " TL Apple Pay ile ödendi.");
    }
}