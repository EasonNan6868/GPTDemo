const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    host:'0.0.0.0',
    port: 7000,
    open:true,
    proxy: {
      '/api': {
        target: 'http://localhost:8088', //跨域请求的公共地址
        ws: false,
        changeOrigin: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    }
  }
})
