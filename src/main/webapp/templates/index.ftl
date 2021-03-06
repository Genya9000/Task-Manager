<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Task Manager</title>
    <link rel="stylesheet" href="../css/main.css">

    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>

</head>
<body>

<nav class="navbar " role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
        <a class="navbar-item" href="#">
            <img src="../images/logobumla.png" width="112" height="28">
        </a>

        <a role="button" class="navbar-burger burger" aria-label="menu" aria-expanded="false"
           data-target="navbarBasicExample">
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
        </a>

    </div>

    <div id="navbarBasicExample" class="navbar-menu ">
        <div class="navbar-start">
            <a class="navbar-item">
                Home
            </a>

            <a class="navbar-item" onclick="alert('Login to your account first')">
                Create task
            </a>
            <a class="navbar-item" onclick="alert('Login to your account first')">
                Update
            </a>

            <a class="navbar-item" onclick="alert('Login to your account first')">
                Delete
            </a>
        </div>

        <div class="navbar-end">
            <div class="navbar-item">
                <div class="buttons">
                    <a class="button is-primary" id="asignup">
                        <strong>Sign up</strong>
                    </a>
                    <a class="button is-light" id="asignin">
                        Log in
                    </a>
                </div>
            </div>
        </div>
    </div>
</nav>
<section class="section">
    <h1 class="title">Сreate your task and don't forget</h1>

    <article class="message is-danger" id="delete1" style="width: 50vw; display: block; text-align: center;
    margin-left: auto;
    margin-right: auto">
        <div class="message-header">
            <p>Danger</p>
            <button class="delete" aria-label="delete"></button>
        </div>
        <div class="message-body">
            ${signUpError}
        </div>
    </article>
    <form action="/signIn" id="signin" method="post" class="signUpIN">
        <div class="field">
            <label class="label">Login</label>
            <div class="control has-icons-left has-icons-right">
                <input class="input " type="text" placeholder="Text input" name="userLogin">
                <span class="icon is-small is-left">
      <i class="fas fa-user"></i>
    </span>
                <span class="icon is-small is-right">
      <i class="fas fa-check"></i>
    </span>
            </div>
            <p class="help is-success is-hidden">This login is available</p>
        </div>
        <div class="field">
            <label class="label">Password</label>
            <p class="control has-icons-left">
                <input class="input" type="password" placeholder="Password" name="userPassword">
                <span class="icon is-small is-left">
      <i class="fas fa-lock"></i>
    </span>
            </p>
        </div>
        <div class="field is-grouped">
            <div class="control">
                <input type="button" class="button is-link" id="btnin" value="Submit">
            </div>
            <div class="content">
                <a class="button is-text cancel2">Cancel</a>
            </div>
            <div class="control"><label class="checkbox" style="margin-top: 0.6em; margin-left: 0.6em">
                    <input type="checkbox" name="saveMe" value="Yes">
                    Save me
                </label></div>
        </div>
    </form>
    <form action="signup" id="signup" method="post" class="signUpIN">
        <div class="field">
            <label class="label">Name</label>
            <div class="control">
                <input class="input" type="text" placeholder="Text input" name="userName">
            </div>
        </div>
        <div class="field">
            <label class="label">Login</label>
            <div class="control has-icons-left has-icons-right">
                <input class="input " type="text" placeholder="Text input" name="userLogin" required>
                <span class="icon is-small is-left">
      <i class="fas fa-user"></i>
    </span>
                <span class="icon is-small is-right">
      <i class="fas fa-check"></i>
    </span>
            </div>
            <p class="help is-success is-hidden">This login is available</p>
        </div>
        <div class="field">
            <label class="label">Password</label>
            <p class="control has-icons-left">
                <input class="input" type="password" placeholder="Password" name="userPassword" required>
                <span class="icon is-small is-left">
      <i class="fas fa-lock"></i>
    </span>
            </p>
        </div>
        <div class="field is-grouped">
            <div class="control">
                <button class="button is-link">Submit</button>
            </div>
            <div class="content">
                <a class="button is-text cancel1 ">Cancel</a>
            </div>
            <div class="control"><label class="checkbox" style="margin-top: 0.6em; margin-left: 0.6em">
                    <input type="checkbox" name="saveMe" value="Yes">
                    Save me
                </label></div>
        </div>
    </form>
</section>
<footer class="footer">
    <div class="content has-text-centered">
        <p>
            <strong>Made</strong> by <a href="http://genya9000.github.io" target="_blank">Yevhen Khaliman</a>. The
            source code is licensed
            <a href="http://opensource.org/licenses/mit-license.php">MIT</a>. The website content
            is licensed <a href="http://creativecommons.org/licenses/by-nc-sa/4.0/">CC BY NC SA 4.0</a>.
        </p>
    </div>
</footer>
<script type="text/javascript" src="../lib/main.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script src="../js/main.js"></script>

</body>
</html>
        
    