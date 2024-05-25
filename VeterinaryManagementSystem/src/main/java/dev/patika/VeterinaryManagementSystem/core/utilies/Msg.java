package dev.patika.VeterinaryManagementSystem.core.utilies;

public class Msg {
    public static final String CREATED = "Kayıt eklendi.";
    public static final String VALIDATE_ERROR = "Veri Doğrulama Hatası.";
    public static final String OK = "İşlem Başarılı.";
    public static final String NOT_FOUND = "Veri Bulunamadı.";
    public static final String SAME_EMAIL = "Bu e-posta adresi ile bir kayıt zaten var.";
    public static final String SAME_PHONE = "Bu telefon numarası ile bir kayıt zaten var.";
    public static final String NOT_FOUND_BY_NAME = "Bu İsme Ait Bir Veri Bulunmamaktadır.";
    public static final String FOUND_BY_NAME = "Veritabanında Aynı Veri Bulunmaktadır.";
    public static String getEntityForMsg(Class<?> entity){
        return entity.getSimpleName() + " Tablosunda Aynı Veri Bulunmaktadır.";
    }
}
