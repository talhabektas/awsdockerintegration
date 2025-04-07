# AWS Docker Projesi

## Proje Açıklaması
Bu projede, Spring Boot tabanlı bir web uygulaması Docker konteynerleri ile paketlendi ve AWS EC2 üzerinde yayınlandı. Proje, kişi bilgilerinin CRUD işlemlerini gerçekleştiren basit bir web uygulamasıdır.

## Kullanılan Teknolojiler
- Spring Boot 3.4.2
- MySQL 8.0
- Docker ve Docker Compose
- Nginx (Ters proxy olarak)
- AWS EC2 (Ubuntu 22.04 LTS)
- Gradle (Build tool)
- Bootstrap 5 (Frontend styling)

## Mimari Yapı
- **Spring Boot Uygulaması**: Person varlığı için CRUD işlemleri gerçekleştiren web uygulaması (8080 portunda çalışır)
- **MySQL**: Verilerin kalıcı olarak saklandığı veritabanı
- **Nginx**: 80 portundan gelen istekleri Spring Boot uygulamasına yönlendiren ters proxy
- **Docker**: Tüm bileşenleri konteynerler içinde çalıştıran platform

## Proje Adımları

### Yerel Geliştirme
1. Spring Boot uygulamasının geliştirilmesi
2. Gradle ile JAR dosyasının oluşturulması: `./gradlew build`
3. Docker imajının oluşturulması: `docker build -t mehmettalha/awsdocker:latest .`
4. Docker imajının test edilmesi: `docker-compose up`

### Docker Hub'a Gönderme
1. Docker Hub'a giriş yapma: `docker login`
2. Docker imajını gönderme: `docker push mehmettalha/awsdocker:latest`

### AWS EC2 Üzerinde Dağıtım
1. EC2 instance oluşturma (Ubuntu 22.04)
2. EC2'ye SSH ile bağlanma
3. Docker ve Docker Compose kurulumu
   ```bash
   sudo apt update
   sudo apt install docker.io docker-compose -y
   sudo systemctl enable docker
   sudo systemctl start docker
   sudo usermod -aG docker ubuntu
   ```
4. Gerekli dosyaları EC2'ye kopyalama
   ```bash
   scp -i <your-key.pem> docker-compose.yml nginx.conf ubuntu@<your-ec2-ip>:~/
   ```
5. Docker Compose ile uygulamayı başlatma
   ```bash
   docker-compose up -d
   ```

## Erişim Bilgileri
- **Docker Hub**: https://hub.docker.com/r/mehmettalha/awsdocker
- **AWS EC2**: http://[EC2-PUBLIC-IP]

## Güncelleme Notları
- Port 8090'dan 8080'e değiştirildi
- Frontend arayüzü Bootstrap 5 ile yeniden tasarlandı
- Nginx yapılandırması iyileştirildi
- Docker Compose servislerine restart politikaları eklendi