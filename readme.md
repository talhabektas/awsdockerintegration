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

## Mimari Yapı
- **Spring Boot Uygulaması**: Person varlığı için CRUD işlemleri gerçekleştiren RESTful API
- **MySQL**: Verilerin kalıcı olarak saklandığı veritabanı
- **Nginx**: 80 portundan gelen istekleri Spring Boot uygulamasına yönlendiren ters proxy
- **Docker**: Tüm bileşenleri konteynerler içinde çalıştıran platform

## Proje Adımları
1. Spring Boot uygulamasının Gradle ile derlenmesi
2. Docker imajının oluşturulması
3. Docker imajının Docker Hub'a gönderilmesi
4. AWS EC2 örneğinin oluşturulması
5. EC2 üzerinde Docker ve Docker Compose kurulumu
6. Docker Compose ile uygulamanın çalıştırılması

## AWS EC2 Yapılandırma Adımları
1. Ubuntu 22.04 LTS AMI ile t2.micro örneği oluşturuldu
2. SSH (22), HTTP (80), ve özel port (8090) için güvenlik grubu yapılandırıldı
3. Docker ve Docker Compose kurulumu yapıldı
4. docker-compose.yml ve nginx.conf dosyaları oluşturuldu
5. Docker Compose ile uygulama başlatıldı

## Erişim Bilgileri
- **Docker Hub**: https://hub.docker.com/r/mehmettalha/awsdocker
- **AWS EC2**: http://[EC2-PUBLIC-IP]

