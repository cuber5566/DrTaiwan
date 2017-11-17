package com.cuber.drtaiwan.repository

import com.cuber.drtaiwan.R
import com.cuber.drtaiwan.util.ResourceTool
import com.cuber.drtaiwan.model.SimpleDoctor
import com.cuber.drtaiwan.model.SimplePost
import io.reactivex.Single

class PostRepository(
        private var resourceTool: ResourceTool = ResourceTool.getInstance()
) {

    fun getSimplePostListByDivisionId(divisionId: String): Single<List<SimplePost>> {

        val simplePostList = ArrayList<SimplePost>()
        simplePostList.add(createTestSimplePost())
        simplePostList.add(createTestSimplePost())
        simplePostList.add(createTestSimplePost())
        simplePostList.add(createTestSimplePost())
        simplePostList.add(createTestSimplePost())
        simplePostList.add(createTestSimplePost())
        simplePostList.add(createTestSimplePost())
        return Single.just(simplePostList)
    }

    private fun createTestSimplePost(): SimplePost {
        return SimplePost("0",
                resourceTool.getString(R.string.test_title),
                resourceTool.getString(R.string.test_sub_title),
                SimpleDoctor("0",
                        resourceTool.getString(R.string.test_doctor_name),
                        resourceTool.getString(R.string.test_doctor_title),
                        resourceTool.getString(R.string.test_avatar_url),
                        resourceTool.getString(R.string.test_clinic_name)),
                5566,
                7788,
                "", "")
    }

    companion object {

        private var INSTANCE: PostRepository? = null

        @JvmStatic
        fun getInstance(): PostRepository {
            return INSTANCE ?: PostRepository()
                    .apply { INSTANCE = this }
        }

        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}