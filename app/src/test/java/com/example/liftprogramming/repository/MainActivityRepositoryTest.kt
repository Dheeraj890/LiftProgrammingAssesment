package com.example.liftprogramming.repository

import com.example.liftprogramming.model.LiftModel
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.runners.MockitoJUnitRunner

@RunWith(JUnit4::class)
class MainActivityRepositoryTest {

    @Mock
   lateinit var repository:MainActivityRepository

    @Mock
    lateinit var list: List<LiftModel>
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

    }

    @After
    fun tearDown() {
    }

    @Test
    fun loadListLift() {

        Mockito.`when`(repository.loadListLift()).thenReturn(list)
      Mockito.`when`(repository.loadListLift().size).thenReturn(6)
        var count=repository?.loadListLift()?.size
        assertTrue(repository?.loadListLift()?.size!! >0)


    }
}