using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace EmployeeManagementMVC.Controllers
{
    public class ErrorHandlerController : Controller
    {
        // Default Error
        [HandleError]
        public ActionResult Error()
        {
            return View();
        }

        //Not Found
        public ActionResult NotFound()
        {
            return View();
        }
    }
}