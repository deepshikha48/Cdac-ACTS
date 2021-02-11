using EmployeeManagementMVC.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace EmployeeManagementMVC.DataAccessLayer
{
    public class EmployeeContext :DbContext
    {
        public EmployeeContext() : base("EmployeeManagement")
        {

        }
        public DbSet<Employee> Employee { get; set; }
    }
}