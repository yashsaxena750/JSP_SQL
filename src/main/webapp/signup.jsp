<!DOCTYPE html>
<html>

<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />

  <title>Hirevac</title>


  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!-- fonts style -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:400,600,700&display=swap" rel="stylesheet">

  <!-- font awesome style -->
  <link href="css/font-awesome.min.css" rel="stylesheet" />
  <!-- nice select -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha256-mLBIhmBvigTFWPSCtvdu6a76T+3Xyt+K571hupeFLg4=" crossorigin="anonymous" />

  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />

  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <style>
    .signup-box {
      background-color: #fff;
      border: 1px solid #ddd;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      max-width: 400px;
      margin: 0 auto;
    }

  </style>

</head>

<body class="sub_page">

  <div class="hero_area">
    <!-- header section strats -->
    <header class="header_section">
      <div class="container-fluid">
        <nav class="navbar navbar-expand-lg custom_nav-container ">
          <a class="navbar-brand" href="index.jsp">
            <span>
              Hirevac
            </span>
          </a>

          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class=""> </span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav  ml-auto">
              <li class="nav-item ">
                <a class="nav-link" href="index.jsp">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="about.jsp"> About</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="job.jsp">Jobs</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <i class="fa fa-user" aria-hidden="true"></i>
                  <span>
                    Login
                  </span>
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <i class="fa fa-user" aria-hidden="true"></i>
                  <span>
                    Sign Up
                  </span>
                </a>
              </li>
              <form class="form-inline">
                <button class="btn   nav_search-btn" type="submit">
                  <i class="fa fa-search" aria-hidden="true"></i>
                </button>
              </form>
            </ul>
          </div>
        </nav>
      </div>
    </header>
    <!-- end header section -->
  </div>
  <br>

  <div class="info_form signup-box">
    <h4>
      Sign Up
    </h4>
    <form action="<%= request.getContextPath()%>/hello-servlet" class="material-signup-form" method="post">
      <div class="form-group">
        <%--@declare id="signupname"--%><label for="signupName">Full Name
        <input type="text" class="form-control" name="signupName" placeholder="Enter your full name" required>
        </label>
      </div>

      <div class="form-group">
        <%--@declare id="signupemail"--%><label for="signupEmail">Email address
        <input type="email" class="form-control" name="signupEmail" placeholder="Enter your email" required>
        </label>
      </div>

      <div class="form-group">
        <%--@declare id="signuppassword"--%><label for="signupPassword">Password
        <input type="password" class="form-control" name="signupPassword" placeholder="Enter your password" required>
        </label>
      </div>

      <div class="form-group">
        <%--@declare id="confirmpassword"--%><label for="confirmPassword">Confirm Password
        <input type="password" class="form-control" name="confirmPassword" placeholder="Confirm your password" required>
        </label>
      </div>

      <input type="hidden" name="action" value="signup">
      <input type="submit" value="Submit" class="btn btn-primary" >
    </form>
  </div>

  <br><br>

  <%

    String error = (String)request.getAttribute("udata");
    if(error!=null)
    {
        out.println("<p style='color:red;text-align:center'>"+error+"</p>");
    }

  %>

  <!-- info section -->
  <section class="info_section ">
    <div class="container">
      <div class="row">
        <div class="col-md-2 info_links">
          <h4>
            Menu
          </h4>
          <ul>
            <li>
              <a href="index.jsp">
                Home
              </a>
            </li>
            <li>
              <a href="about.jsp">
                About
              </a>
            </li>
            <li>
              <a href="job.jsp">
                Jobs
              </a>
            </li>
          </ul>
        </div>
        <div class="col-md-3">
          <h4>
            Jobs
          </h4>
          <p>
            Established fact that a reader will be distracted by the readable content of a page when looking at its
            layout. The point of using Lorem Ipsum
          </p>
        </div>
        <div class="col-md-3">
          <div class="info_social">
            <h4>
              Social Link
            </h4>
            <div class="social_container">
              <div>
                <a href="#">
                  <i class="fa fa-facebook" aria-hidden="true"></i>
                </a>
              </div>
              <div>
                <a href="">
                  <i class="fa fa-twitter" aria-hidden="true"></i>
                </a>
              </div>
              <div>
                <a href="">
                  <i class="fa fa-linkedin" aria-hidden="true"></i>
                </a>
              </div>
              <div>
                <a href="">
                  <i class="fa fa-instagram" aria-hidden="true"></i>
                </a>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="info_form">
            <h4>
              Newsletter
            </h4>
            <form action="">
              <label>
                <input type="text" placeholder="Enter Your Email" />
              </label>
              <button type="submit">
                Subscribe
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- end info_section -->

  <!-- footer section -->
  <footer class="footer_section">
    <div class="container">
      <p>
        &copy; <span id="displayYear"></span> All Rights Reserved By
        <a href="https://html.design/">Free Html Templates</a>
      </p>
    </div>
  </footer>
  <!-- footer section -->

  <!-- jQery -->
  <script src="js/jquery-3.4.1.min.js"></script>
  <!-- bootstrap js -->
  <script src="js/bootstrap.js"></script>
  <!-- nice select -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/js/jquery.nice-select.min.js" integrity="sha256-Zr3vByTlMGQhvMfgkQ5BtWRSKBGa2QlspKYJnkjZTmo=" crossorigin="anonymous"></script>
  <!-- custom js -->
  <script src="js/custom.js"></script>


</body>

</html>