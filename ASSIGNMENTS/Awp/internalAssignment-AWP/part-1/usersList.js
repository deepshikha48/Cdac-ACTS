// array of users
var users=[
    {username:"Shikha",password:"1234",email:"shikha@gmail.com",phoneNo:"9991215544"},
    {username:"Diksha",password:"56aa",email:"diksha30@gmail.com",phoneNo:"9991124455"},
    {username:"Archana",password:"xxxx",email:"sukhija@gmail.com",phoneNo:"8940053080"},
    {username:"Deepika",password:"8900",email:"deepika@gmail.com",phoneNo:"8706953500"}
]

// function to display users 
function showUsers(){
    var tableTag=document.createElement("table");
    var tableHeadingRow=document.createElement("tr");
    tableHeadingRow.innerHTML="<th>Name</th><th>Password</th><th>Email</th><th>Contact</th>";
    tableTag.appendChild(tableHeadingRow);
    for(i=0;i<users.length;i++){
        var tableContentRow=document.createElement("tr");
        tableContentRow.innerHTML="<td>"+users[i].username+"</td><td>"+users[i].password+"</td><td>"+users[i].email+"</td><td>"+users[i].phoneNo+"</td>";
        tableTag.appendChild(tableContentRow);
    }
    document.getElementById("content").appendChild(tableTag);
}