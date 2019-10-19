package com.example.myapplication


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.network.model.PostInfo
import com.example.myapplication.network.repository.RetrofitRepository
import com.example.myapplication.network.viewmodel.RetroViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.times
import org.mockito.MockitoAnnotations





@RunWith(MockitoJUnitRunner::class)
class RetroViewModelTest {

    lateinit var retroViewModel: RetroViewModel
    @Mock
    lateinit var retrofitRepository: RetrofitRepository
    private lateinit var postInfoEmptyList:List<PostInfo>
    private val mockList:MutableList<PostInfo>  = mutableListOf()
    private val mockLiveData: MutableLiveData<List<PostInfo>> = MutableLiveData<List<PostInfo>>()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun init(){
        MockitoAnnotations.initMocks(this);
        this.retroViewModel = RetroViewModel(this.retrofitRepository)

        mockData()
       // retroViewModel.postInfoLiveData
    }

    @Test
    fun fetchPostInfoFromRepositoryTest(){
        Mockito.`when`(retrofitRepository.fetchPostInfoList()).thenReturn(mockLiveData)
        retroViewModel.postInfoLiveData = mockLiveData
        Assert.assertNotNull(retroViewModel.postInfoLiveData.value)
        Assert.assertTrue(retroViewModel.postInfoLiveData.value?.size==3)

    }

    private fun mockData(){
        postInfoEmptyList= emptyList()


        mockList.add(PostInfo("Post Title1","Museo Nacional de Arqueología, Antropología e Historia del Perú","1"))
        mockList.add(PostInfo("Post Title2","Museo Nacional de Arqueología, Antropología e Historia del Perú","2"))
        mockList.add(PostInfo("Post Title3","Museo Nacional de Arqueología, Antropología e Historia del Perú","3"))

        postInfoEmptyList= mockList.toList()
        mockLiveData.postValue(postInfoEmptyList)

    }
}


//https://github.com/emedinaa/kotlin-mvvm/tree/master/KotlinMVVM/app/src/test/java/com/emedinaa/kotlinmvvm