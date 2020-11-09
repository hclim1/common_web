package com.hclim1.common.demo.example.domain


class Example(var firstName : String,
			  var lastName : String,
			  var age : Int){
	var key : String = "";
	//Custom Getter
	private val fullName : String
		// Same Function : fun getFullName() : String{ return firstName + lastName }
		get() {
			return firstName + lastName;
		}

	override fun toString():String{
		return "First Name : $firstName, Last Name : $lastName, age: $age"
	}
}