<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>

    <script src="https://cdn.jsdelivr.net/npm/vue@2.6.11"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.min.js" integrity="sha384-lpyLfhYuitXl2zRZ5Bn2fqnhNAKOAaM/0Kr9laMspuaMiZfGmfwRNFh8HlMy49eQ" crossorigin="anonymous"></script>
</head>
<body>

<div class="container" id="app">
    <div class="row">
        <div class="col-12">
            <a href="hello-servlet" class="btn btn-primary">Hello Servlet</a>
        </div>

        <div class="col-12">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="user in users">
                    <th scope="row">{{ user.id }}</th>
                    <td>
                        <a v-bind:href="'ServletUser?id=' + user.id">{{ user.name }}</a>
                    </td>
                    <td>{{ user.email }}</td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="col-12">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">session</th>
                    <th scope="col">client_id</th>
                    <th scope="col">created_at</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="order in orders">
                    <th scope="row">{{ order.id }}</th>
                    <td>{{ order.don_session_id }}</td>
                    <td>{{ order.client_id }}</td>
                    <td>{{ order.created_at }}</td>
                </tr>
                </tbody>
            </table>
        </div>

    </div>
</div>

<script>
    var vue = new Vue({
        el: '#app',
        data: {
            users : {},
            orders : {},
        },
        created() {
           // this.getUsers();
            this.getOrders();
        },
        methods: {
            getUsers() {
                axios.get('ServletUsers')
                    .then(response => {
                        this.users = response.data;
                    })
                    .catch(response => {
                        alert('fail')
                    });
            },
            getOrders() {
                axios.get('ServletOrders')
                    .then(response => {
                        this.orders = response.data;
                    })
                    .catch(response => {
                        alert('fail')
                    });
            },
        },
    });
</script>

</body>
</html>