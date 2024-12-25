package com.example.technicaltest2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class StudentAdapter(private val studentList: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImageView: ImageView = itemView.findViewById(R.id.profilePicture)
        val nameTextView: TextView = itemView.findViewById(R.id.studentName)
        val addressTextView: TextView = itemView.findViewById(R.id.studentAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]

        holder.nameTextView.text = student.name
        holder.addressTextView.text = student.address
        Glide.with(holder.profileImageView.context) //bisa menggunakan transform(circleCrop())
            .load(student.profilePictureUrl)
            .placeholder(R.drawable.baseline_person_24) // Placeholder while loading
            .into(holder.profileImageView)
    }

    override fun getItemCount(): Int = studentList.size
}
