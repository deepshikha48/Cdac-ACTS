using EmployeeManagementMVC.DataAccessLayer;
using EmployeeManagementMVC.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace EmployeeManagementMVC.Controllers
{
    public class EmployeeController : Controller
    {
        EmployeeContext context = new EmployeeContext();

        // GET: All Employees
        public ActionResult Index()
        {
            var Emplist = context.Employee.ToList();
            return View(Emplist);
        }

        //Insert:New Employee
        [HttpGet]
        public ActionResult Create()
        {

            return View();
        }

        [HttpPost]
        public ActionResult Create(Employee emp)
        {
            if (ModelState.IsValid)
            {
                context.Employee.Add(emp);
                context.SaveChanges();
                return RedirectToAction("Index", "Employee");
            }
            return View();
        }

        //Edit: Employee Details
        [HttpGet]
        public ActionResult Edit(int id)
        {
            var Emplist = context.Employee.ToList();
            // Find employee using LinQ
            var employee = Emplist.FirstOrDefault(emp => emp.Id == id);

            return View(employee);
        }

        [HttpPost]
        public ActionResult Edit(Employee emp)
        {
            if (ModelState.IsValid)
            {
                context.Entry(emp).State = EntityState.Modified;
                context.SaveChanges();
                return RedirectToAction("Index", "Employee");
            }
            else
            {
                return View();
            }

        }

        //Delete: Employee
        [HttpGet]
        public ActionResult Delete(int id)
        {
            var emp = context.Employee.Find(id);
            return View(emp);
        }

        [HttpPost]
        public ActionResult Delete(int id, Employee emp)
        {
            emp = context.Employee.Find(id);
            context.Employee.Remove(emp);
            context.SaveChanges();
            return RedirectToAction("Index", "Employee");
        }
    }
}