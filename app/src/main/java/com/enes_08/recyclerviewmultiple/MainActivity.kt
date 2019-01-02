package com.enes_08.recyclerviewmultiple

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.enes_08.recyclerviewmultiple.adapter.PostAdapter
import com.enes_08.recyclerviewmultiple.model.Post
import com.enes_08.recyclerviewmultiple.model.User
import org.intellij.lang.annotations.Language

class MainActivity : AppCompatActivity() {

    private lateinit var mPostList: ArrayList<Post>

    lateinit var madaptor: PostAdapter
    private var recyclerView: RecyclerView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recylerView)
        mPostList = ArrayList()


        madaptor = PostAdapter(this, mPostList)
        recyclerView?.adapter = madaptor


        initData()


    }

    private fun initData() {

        var mUser = User("1", "Enes Başkaya","Android Developer", R.drawable.test2)
        var mUser2 = User("1", "Selin Kara","Graphic Designer" ,R.drawable.test3)
        var mUser3 = User("1", "Ahmet Aydın","Software Engineer" ,R.drawable.test4)



        var mPost1 = Post(
            mUser,
            "Android",
            "Android; Google ve Open Handset Alliance tarafından, mobil cihazlar için geliştirilmekte olan, Linux tabanlı özgür ve ücretsiz bir işletim sistemidir. Sistem açık kaynak kodlu olsa da, kodlarının ufak ama çok önemli bir kısmı Google tarafından kapalı tutulmaktadır.",
            "25.12.2018",
            "10K"
        )


        var mPost2 = Post(mUser2, "En genç nüfusa sahip ülke Nijer", R.drawable.dunyadan8, "01.01.2019", "250K")


        var mPost3 = Post(
            mUser3,
            "Suudi Arabistan",
            "Üzerinde hiç nehir bulunmayan ülke.Suudi Arabistan resmî adıyla Suudi Arabistan Krallığı, Arap Yarımadası'nda bulunan en büyük ülkedir. Kuzeybatı'da Ürdün, kuzey ve kuzeydoğu'da Irak, doğuda Kuveyt, Katar, Bahreyn ve Birleşik Arap Emirlikleri, güneydoğuda Umman, güneyde Yemen, kuzeydoğusunda Basra Körfezi ve batısında Kızıldeniz ile çevrilidir",
            R.drawable.dunyadan7,
            "22.01.2019",
            "2K"
        )

        var mPost4 = Post(
            mUser,
            "Android",
            "Bu zamana kadar tanıtılmış en iyi Android sürümü olarak lanse edilen 9.0 Pie beta sürecinin sonuna geldi ve öncü markaların dağıtım listesi belli oldu. Bütün Android kullanıcılarının genel sorunu cihazlarının güncelleme alıp almayacağı. Markalardan resmi açıklama bekleyen kullanıcılar resmi hesapları kontrol etmeye başladı bile. Hangi telefonlara Android pie güncellemesi gelecek?",
            "02.03.2019",
            "100"
        )
        var mPost5 = Post(
            mUser,
            "Kotlin",
            "Kotlin, Java sanal makinesi üzerinde çalışan ve ayrıca JavaScript kaynak koduna derlenebilir, statik tipli bir programlama dilidir. İlk geliştirme Saint Petersburg, Rusya merkezli JetBrains programcıları tarafından yapılmıştır. İsmi Kotlin Adası'ndan gelmektedir.",
            "05.03.2019",
            "12K"
        )


        mPostList.clear()
        mPostList.add(mPost1)
        mPostList.add(mPost2)
        mPostList.add(mPost3)
        mPostList.add(mPost4)
        mPostList.add(mPost5)

        madaptor.notifyDataSetChanged()


    }
}
