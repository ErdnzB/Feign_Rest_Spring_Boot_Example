


<h1 align="left">Feign / Kafka Consumer-Producer / H2 </h1>

<h3 align="left">Backend Application </h3>

### Description

Merhabalar,

Uygulama 2 farklı ms üzerinde birbiriyle Feign ve Kafka aracılığıyla haberleşen basit bir logic'e sahiptir.

ilk Campaign Ms'i üzerinde bulunan docker file'ı çalıştırarak başlayabilirsiniz.Bunu yapmak için gerekli olan attr'lar .yml da tanımlanmıştır.

Dikkat : application.yml üzerinde kafka topic'i belirtilmiştir.Bu topic'i veya ekleyeceğiniz herhangi bir topic'i aşağıdaki komutla yaratabilirsiniz.

Docker file çalıştırmadan itibaren sırasıyla aşağıdaki adımları izleyebilirsiniz.

-->docker-compose up -d 

##Bash'e ulaşıp kafka topic'ini yaratalım.
-->docker-compose exec kafka bash 

##Bash erişimi terminalde görüldükten sonra aşağıdaki şekilde topic'inizi yaratabilirsiniz.
-->/bin/kafka-topics --create --topic topic-name --bootstrap-server localhost:9092 

##Baktınız herşey felaket bu aşağıdaki kullanımıda deneyebilirsiniz çünkü neden olmasın :)
-->/bin/kafktopics --create --topic topic-name --partitions 1 --replication-factor 1ng --bootstrap-server localhost:9092


Herşeyin sıkıntısız çalıştığından emin olduktan sonra ilk önce bir campaing tanımlayarak daha sonra diğer ms üzerinden publish metoduyla tanımladığınız campaign'i feignClient ile alıp bir publish yapabilirsiniz.(Bu sırada kod üzerinde göreceğiniz gibi Kafka'ya yazıp ilk ms üzerinden okunup verify tablosuna kayıt atılacaktır.)

