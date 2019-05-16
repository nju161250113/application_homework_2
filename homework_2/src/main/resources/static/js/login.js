
(function () {
  const loginBtn = document.getElementById('login-btn');

  loginBtn.addEventListener('click', function () {
      let id = document.getElementById('id').value;
      let password = document.getElementById('password').value;

      axios.post('/student/login/' + id + '/' + password)
          .then(function  (response) {
              if (response.data) {
                  window.location = '/coursepage?stuId=' + id;
              } else {
                  alert('用户名或密码错误');
              }
          })
          .catch(function (error) {
              console.log(error);
          });

  });

})();