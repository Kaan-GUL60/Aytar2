package com.gkaan.aytar

class saveUser {
    var pName: String = ""
    var pId: String = ""
    var pEmail: String = ""
    var pPassword: String = ""
    var pImageLink: String = ""
    var pSanalBakiye: Int = 0

    constructor(pName: String, pId: String, pPassword: String, pEmail: String, pImageLink: String,pSanalBakiye: Int) {
        this.pId = pId
        this.pName = pName
        this.pPassword = pPassword
        this.pEmail = pEmail
        this.pImageLink = pImageLink
        this.pSanalBakiye = pSanalBakiye
    }

}

/*   veri yazma
    var database = FirebaseDatabase.getInstance().reference

    var pName = binding.pName.text.toString().toInt()
    var pId = ...
   // database.setValue(saveUser(pName,pId,...))
   database.child(pId.tostring()).setValue(saveUser(pName,pId,...))  //child tag oluşturup onun altına ekler verileri devamındaki
 */

/*
    veri okuma

    var getData= object: ValueEventListener{   //object in üstüne tıkla implement et
    override fun onDataChange(snapshot: DataSnapshot){
        var sb = StringBuilder() //metin birlerşitrme sınıfı
        for(i in snapshot.children){
            var pdsıyad = i.child("pAdsoyad").getValue
            var pdenem = i.child("pAdsoyad").getValue
            sb.append("${i.key} ${adsoyad} ${maas} \n")
        }
        binding.textBox.setText(sb)


    }
    }
    database.addValueEventListener(getdata)
 */