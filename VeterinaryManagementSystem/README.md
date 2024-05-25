# Veteriner Yönetim Sistemi - Bitirme Projesi

## Proje Tanımı

Bir veteriner kliniğinin işlerini yönetmek için kullanılan bir API projesidir. Bu proje Katmanlı Mimari yapısı ile Java - Spring Boot - Spring Data JPA - PostgreSQL  - Maven teknolojileri kullanılarak yapılmıştır.

Bu projenin amacı  veteriner çalışanlarının doktorlarını, müşterilerini, hayvanlarını, aşılarını ve randevularını yönetmektir.

[UML Diyagramı ](images/Veterinary_Uml_Diyagrami.png)

## Proje Özellikleri

### Hayvan ve Sahiplerinin Yönetimi

- Hayvan Kaydetme, Güncelleme, Görüntüleme ve Silme
- Sahip Kaydetme, Güncelleme, Görüntüleme ve Silme
- Hayvan sahiplerini isme göre filtreleme
- Hayvanları isme göre filtreleme
- Hayvan sahibine göre hayvanları filtreleme


### Uygulanan Aşıların Yönetimi

- Aşı Kaydetme, Güncelleme, Görüntüleme ve Silme
- Aşı koruyuculuk bitiş tarihi geçmemişse yeni aşı eklenmemesi
- Hayvan id’sine göre aşı kayıtlarını listeleme
- Aşı koruyuculuk bitiş tarihi aralığında olan aşıları listeleme

### Veteriner Doktor Yönetimi

- Doktor Kaydetme, Güncelleme, Görüntüleme ve Silme
- Doktorun müsait günlerini ekleme, güncelleme, görüntüleme ve silme


### Randevu Yönetimi

- Randevu oluşturma, güncelleme, görüntüleme ve silme
- Doktorun müsait günü ve saati kontrolü ile randevu oluşturma
- Tarih aralığına ve doktora göre randevuları filtreleme
- Tarih aralığına ve hayvana göre randevuları filtreleme


## İlişkiler

- **Customer** - **Animal**: OneToMany
- **Animal** - **Vaccine**: OneToMany
- **Doctor** - **AvailableDate**: OneToMany
- **Doctor** - **Appointment**: OneToMany
- **Animal** - **Appointment**: OneToMany

## API Endpoints

### Hayvan Yönetimi

- **GET   /v1/animals/{name}**: Hayvanları isme göre listeleme
- **GET   /v1/animals**: Hayvan detaylarını görüntüle
- **POST   /v1/animals**: Yeni hayvan ekleme
- **PUT    /v1/animals**: Hayvan bilgilerini güncelle
- **DELETE  /v1/animals/{id}**: Hayvanı sil
- **GET /v1/animals/customer/{id}** : Customer id'e göre hayvanları getirir
- [Animal veri tablosu ](images/Animal.JPG)

### Müşteri Yönetimi

- **GET /v1/customers/{name}**: Müşterileri isme göre listeleme
- **GET /v1/customers**: Müşteri detaylarını id ye göre görüntüleme
- **POST /v1/customers**: Yeni müşteri ekleme
- **PUT /v1/customers**: Müşteri bilgilerini güncelleme
- **DELETE  /v1/customers/{id}**: Müşteri sil
- [Customer veri tablosu ](images/Customer.JPG)

### Aşı Yönetimi

- **GET /v1/vaccines/findbyDate**: Aşıları başlangıç ve bitiş tarihe göre listeleme
- **GET v1/vaccines**: Aşı detaylarını görüntüleme
- **POST /v1/vaccines**: Yeni aşı ekleme
- **PUT /v1/vaccines**: Aşı bilgilerini güncelleme
- **DELETE  /v1/vaccines/{id}**: Aşı sil
- **GET /v1/vaccines/animal/{id}** : Hayvan id'e göre aşıları getirir
- [Vaccine veri tablosu ](images/Vaccine.JPG)

### Doktor Yönetimi

- **GET /v1/doctors**: Doktorları listeleme
- **POST /v1/doctors**: Yeni doktor ekleme
- **PUT /v1/doctors**: Doktor bilgilerini güncelleme
- **DELETE  /v1/doctors/{id}**: Doktor sil
- [Doctor veri tablosu ](images/Doctor.JPG)

### Doktorun Müsait Gün  Yönetimi

- **GET   /v1/available-dates**: Doktor müsait günleri listeler
- **POST   /v1/available-dates**: Yeni müsait gün ekleme
- **PUT    /v1/available-dates**: Müsait günleri güncelle
- **DELETE  /v1/available-dates/{id}**: Müsait günü sil
- [AvailableDate veri tablosu ](images/AvailableDate.JPG)

### Doktora Randevu Atama Yönetimi

- **GET   /v1/appointments**: Randevuları getirir
- **GET   /v1/appointments/filterbyDrDate/{doctorId}**: Doktora göre  detaylarını görüntüle
- **GET   /v1/appointments/filterbyAnmlDate/{animalId}**: Hayvana göre detaylarını görüntüle
- **POST   /v1/appointments**: Yeni randevu ekleme
- **PUT    /v1/appointments**: Doktor randevu tarihlerini güncelle
- **DELETE  /v1/appointments/{id}**: Randevuyu sil
- [Apointment veri tablosu ](images/Appointment.JPG)
