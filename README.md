Proje MVC mimari kurallarına göre uygun paketlenmiştir. SOLID prensipleri kurallarına ve Nesne Tabanlı Programlama kurallarına uygun temiz kod çalışılmıştır.
Projede tüm string, renk ve boyutlar resourcelerden çekilmiştir.

Proje 3 ekrandan oluşmakta
E-1 Splash Ekranı:
  *3 saniye kendi tasarımım logo görünür.
  *İnternet kontrolü ile interneti olmayan kullanıcı ayarlara yönlendirilir.

E-2 Liste Ekranı:
  * Ekranın üstübde uygulama tanıtılan bir alan yer alır.
  * Alt tarafında recycleView içerisinde CardView ile listelenen şarkı itemleri bulunur.
  * Veriler Githubtan json dosyasından Retrofit2 ile okunur
  * İtemler ile ilgili resimler githubtan Glide ile çekilir.
  * Geri butonuna basılması durumunda çıkış yapmak isteyip istenilmediği sorulur.
  * İLgili iteme tıklanıldığında E3 ekranı açılır
 
 E-3: Detay Ekranı:
  *Json servisten dönen Glide ile çekip Resim gösterilir.
  *Resim altında Textview başlığı yer alır.
  *Başlığın altında Jsondan dönen HTML data burada gösteilir
  *Ekrandaki tüm nesneler Nested Scroll özelliğine sahiptir.
