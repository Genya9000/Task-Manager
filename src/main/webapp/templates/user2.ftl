<#ftl encoding="UTF-8"/>
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

            <a class="navbar-item" id="create">
                <p>Create task</p>
            </a>
            <a class="navbar-item" id="update">
                <p>Update</p>
            </a>

            <a class="navbar-item" id="delete">
                <p><input type="submit" name="submit" value="Delete" form="updateDelete" style="border: none"></p>
            </a>
        </div>

        <div class="navbar-end">
            <div class="navbar-item">
                <div class="buttons">

                    <a class="button is-light" onClick='location.href="/logOut"'>
                        Log out
                    </a>
                </div>
            </div>
        </div>
    </div>
</nav>
<section class="section">
    <h1 class="title">Welcome ${name}!</h1>
    <form action="create" method="post" id="createf">

        <input class="input is-info field control" type="date" placeholder="Date input" required
               style="text-align: center; " name="userDate">


        <textarea class="textarea is-info field control" placeholder="What I should do" required
                  style="text-align: center; " name="userText"></textarea>

        <div class="field is-grouped">
            <div class="control">
                <button class="button is-link ">Submit</button>
            </div>
            <div class="content">
                <a class="button is-text cancel1 ">Cancel</a>
            </div>
        </div>
    </form>

    <table class="table is-striped">
        <thead>
        <tr style="height: 7vh">
            <th>#</th>
            <th>Mark</th>
            <th>Date</th>
            <th>Your Task</th>
        </tr>
        </thead>
        <tbody>
        <#if tasks??>
            <form action="deleteUpdate" method="post" id="updateDelete">
            <div class="taskUpdate" style="display: none">
            <textarea class="textarea is-info field control" id="updateText" placeholder="What I should do"
                      style="text-align: center; " name="userText"></textarea>

                <div class="field is-grouped">
                    <div class="control">
                        <button class="button is-link "><p><input type="submit" name="submit" value="Update"
                                                                  form="updateDelete" style="border: none"></p></button>
                    </div>
                    <div class="content">
                        <a class="button is-text cancel3 ">Cancel</a>
                    </div>
                </div>
            </div>
            <#list tasks as task>

            <tr style="height: 7vh">
                <td>
                    ${task?index}
                <td><label class="checkbox">
                        <input type="checkbox" name="checkbox" value="${task.id}">
                    </label>
                <td>${task.date}
                <td>${task.text}
                    </#list> </form></#if>
        </tbody>
    </table>
    <nav class="pagination" role="navigation" aria-label="pagination">
        <a class="pagination-previous" title="This is the first page">Previous</a>
        <a class="pagination-next">Next page</a>
        <ul class="pagination-list">
            <li>
                <a class="pagination-link " aria-label="Page 1" aria-current="page" href="/pagination?page=1">1</a>
            </li>
            <li>
                <a class="pagination-link is-current" aria-label="Goto page 2" href="/pagination?page=2">2</a>
            </li>
            <li>
                <a class="pagination-link" aria-label="Goto page 3" href="/pagination?page=3">3</a>
            </li>
        </ul>
    </nav>
</section>

<script type="text/javascript" src="../lib/main.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script src="../js/main.js"></script>

</body>
</html>
