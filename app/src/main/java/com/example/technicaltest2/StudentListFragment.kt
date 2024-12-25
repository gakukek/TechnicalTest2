package com.example.technicaltest2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class StudentListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var studentAdapter: StudentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_student_list, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Add placeholder students
        val studentList = generatePlaceholderStudents()

        studentAdapter = StudentAdapter(studentList)
        recyclerView.adapter = studentAdapter


        return view
    } //boilerplate generic students

    private fun generatePlaceholderStudents(): List<Student> {
        return listOf(
            Student("John Doe", "123 Main St", "https://tr.rbxcdn.com/180DAY-d2aa8b558f4c73dc77ab184210a56788/420/420/Hat/Webp/noFilter"),
            Student("Jane Smith", "456 Maple Ave", "https://wallpapers-clan.com/wp-content/uploads/2022/07/funny-cat-1.jpg"),
            Student("Alice Johnson", "789 Oak Blvd", "https://preview.redd.it/juno-standing-cat-pfp-v0-6dt9a4d00crd1.jpeg?auto=webp&s=6c5c4bcb350cd949a339342a79c9ec2ccea79d6f"),
            Student("Bob Brown", "321 Pine Dr", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS14nVfUQ-NkjiQjUPYoIGxHAGxY5PsH01DSg&s"),
            Student("Emma Wilson", "654 Elm St", "https://cdn.prod.website-files.com/62bdc93e9cccfb43e155104c/654f69d23fcb98cd61124a06_Dog%2520PFP%2520for%2520Tiktok%25204.png"),
            Student("Liam Martinez", "987 Cedar Ln", "https://i.pinimg.com/236x/e9/78/cd/e978cd75998c1da7952ab37009e73cfc.jpg"),
            Student("Noah Anderson", "135 Birch Rd","https://i.pinimg.com/236x/6e/72/b3/6e72b3ca9fbd2dccf59103aed1ee227a.jpg"),
            Student("Olivia Taylor", "246 Walnut Ave", "https://i.pinimg.com/736x/34/16/40/34164025fe4118ebd8885bad22c09128.jpg"),
            Student("Sophia Thomas", "357 Spruce Ct","https://i.pinimg.com/originals/d3/38/a0/d338a00eca4dd64701d514dba4ea87c0.jpg"),
            Student("James Lee", "468 Aspen Way","https://i.pinimg.com/200x/16/ed/ff/16edfff4cfc69f8c58054793e2947aa0.jpg")
        )
    }

}