# ekip-toy-project

## Servisler

Tüm servisler GET methoduyla çalışıyor.
Servis adresi: http://env-6931569.jelastic.dogado.eu/
Kullanılabilir Servisler: Check, Login.

### Check

Herhangi bir parametre verilmedigi zaman, ekip elamanlarının isimlerini array olarak döndürüyor. Örnek: http://env-6931569.jelastic.dogado.eu/Check

name parametresine yukarıdaki sorgudan dönen herhangi bir elemanın ismi verildiğinde o elemanın tüm ismini dönüyor. Örnek: http://env-6931569.jelastic.dogado.eu/Check?name=ali sorgusu "seref ali yataman" sonucunu veriyor.

Bunlar dışındaki tüm durumlarda "error" sonucunu dönüyor.

### Login

Kullanıcı adı ve şifre girdilerini kontrol ediyor. Aslında server tarafında herhangi bir kullanıcı-şifre bilgisi yok ama client tarafında login olayını test etmek için kullanılabilir.
username ve password olmak üzere 2 parametre alıyor.

username ve password'ün verilmesi durumunda eğer username-password eşleşmesi doğru ise "OK" sonucunu aksi takdirde "WRONG" sonucunu dönüyor.

Diğer tüm durumlarda request'in valid bir request olmadığını gösteren "BAD" sonucunu dönüyor.

"OK" sonucu vermesi için gereken bilgiler.
Username: ekip
Password: 123456

Örnek: http://env-6931569.jelastic.dogado.eu/Login?username=ali&password=63985 wrong sonucunu dönüyor.

## Useful Links
[Sublime Editor](http://www.sublimetext.com/)

[Github Download](https://windows.github.com/)

[git.cmd](http://www.selcukgulcan.com/ezlinks/git.rar)

[JSFiddle Demo](http://jsfiddle.net/Shathra/envbmbac/#&togetherjs=MrgANNfFNp)
