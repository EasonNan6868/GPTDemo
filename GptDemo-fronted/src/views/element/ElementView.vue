<template>
  <div>

    <el-container style="height: 700px; border: 1px solid #eee">
      <el-header>ChatGPT3.5调用demo</el-header>
      <el-main>
        <el-row>
          <span>对话内容</span>
        </el-row>

        <el-row>
          <el-input class="input"
                    type="textarea"
                    :rows="5"
                    placeholder="请输入内容"
                    v-model="textarea">
          </el-input>
        </el-row>

        <el-row>
          <el-button  type="primary" style="float: right" @click="invoke">提交</el-button>
        </el-row>

        <el-row>
          <span style=" line-height: 30px">ChatGPT响应结果为:</span>
        </el-row>
        <el-row>
          <el-card class="box-card">
            <div class="text item">
              {{resultMessage}}
            </div>
          </el-card>
        </el-row>
      </el-main>
    </el-container>





  </div>
</template>

<script>
import axios from 'axios'

export default {

  data() {
    return {
      textarea: '',
      resultMessage:''
    }
  },
  methods:{
    invoke(){
      axios.post('/api/gpt/invoke',{
        message:this.textarea
          }
      ).then((result)=>{
        this.resultMessage=result.data;
      })
    }
  }

}
</script>

<style scoped>
  .el-header{
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }
  .text {
    font-size: 14px;
  }

  .box-card {
    height: 260px;
  }
  .el-row {
    margin-bottom: 20px;
  }

</style>