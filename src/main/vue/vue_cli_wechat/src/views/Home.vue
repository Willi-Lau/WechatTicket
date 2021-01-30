<template>
  <div class="home">
<!--    活动图片-->
    <div class="img">
      <img src="../assets/active/ALL_Star.jpg" style="width: 100%">
    </div>
<!--    报名数量等-->
    <div class="number" >
<!--      已经报名-->
      <div class="enter">
          已报名 <br><br>
        {{this.totalperson}}
      </div>
      <!--    己经投票-->
      <div class="ticket">
            累积投票<br><br>
          {{this.totaltickets}}
      </div>
<!--      访问量-->
      <div class="look">
          访问量<br><br>
          {{this.totalaccess}}
      </div>
    </div>
<!--      计时器-->
      <div style="margin-top: 20px">
          {{this.between_inf}}
          <p>倒计时：{{this.day}}天{{this.hour}}小时{{this.minute}}分{{this.second}}秒</p>
      </div>
      <!--      报名按钮-->
      <div style="margin-top: 20px">
          <el-button style="width: 350px" type="success" @click="enter()">我要报名</el-button>
      </div>

      <!--      搜索区域-->
      <div style="margin-top: 30px">
          <el-form :inline="true" :model="formInline" class="demo-form-inline">
              <el-form-item label="输入信息">
                  <el-input v-model="formInline.inf" placeholder="输入信息"></el-input>
              </el-form-item>
              <el-form-item label="查询方式">
                  <el-select v-model="formInline.type" placeholder="id姓名等">
                      <el-option label="id查询" value="cid" ></el-option>
                      <el-option label="姓名查询" value="cname"></el-option>
                      <el-option label="全部查询" value="all"></el-option>
                  </el-select>
              </el-form-item>
              <el-form-item>
                  <el-button type="primary" @click="onSubmit">查询</el-button>
              </el-form-item>
          </el-form>
      </div>
<!--      搜索结果-->
      <div>
          <div v-for="(item,index) in candidate" class="router_buy_all" style="border: 1px solid darkgray" @click="candidateinf(item.cid)">


              <img class="router_buy_all_img" :src=item.imgurl width="100px" >
              选手id:<span>{{item.cid}}</span>
              选手票数:<span>{{item.tickets}}</span>


          </div>
<!--          分页-->
          <div class="block">
              <span class="demonstration">调整每页显示条数</span>
              <el-pagination
                      @size-change="handleSizeChange"
                      @current-change="handleCurrentChange"
                      :current-page.sync="page"
                      :page-sizes="[5, 10, 30, 100]"
                      :page-size="pagesize"
                      layout="sizes, prev, pager, next"
                      :total="totalperson"
              small>
              </el-pagination>
          </div>
      </div>




      <div class="bottomsp"></div>


    <BottomComponents></BottomComponents>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import BottomComponents from '@/components/BottomComponents.vue'
export default {
  data(){
    return{
          totalperson:0,
          totaltickets:0,
          totalaccess:0,
        hours: 0,
        minutes: 0,
        seconds: 0,
        day:0,
        between:'',
        between_inf:'',
        formInline: {
            inf: '',
            type: ''
        },
        candidate:{

        }
        ,
        currentPage4: 4,
        page:1,
        pagesize:10,


    }
  },
  created() {
          //  查看报名活动的人数

          this.$axios.post('HomeController/selecttotalpeople',
              this.$qs.stringify(
                  {aid:1}
              )

          ).then(response=>{      //返回值部分
              this.totalperson = response.data
          }).catch(error=>{
              console.log(error)
          });
          //将访问记录+1 再查询人数

          this.$axios.post('HomeController/updateselecttotalaccess',
              this.$qs.stringify(
                  {aid:1}
              )

          ).then(response=>{      //返回值部分
              this.totalaccess = response.data
          }).catch(error=>{
              console.log(error)
          });

          //查询结束时间

      this.$axios.post('HomeController/selectactivityendtime',
          this.$qs.stringify(
              {aid:1}
          )

      ).then(response=>{      //返回值部分
          this.between = response.data.between
          if(this.between === "大于"){
              this.between_inf = "距离活动结束还有"
          }
          else {
              this.between_inf = "活动已经结束"
          }
              this.day = response.data.day
              this.hours = response.data.hour
              this.minutes = response.data.min
              this.seconds = response.data.s


      }).catch(error=>{
          console.log(error)
      });
      //查询所有选手信息
      this.$axios.post('HomeController/selectcandidatebytype',
          this.$qs.stringify(
              {
                  inf:this.formInline.inf,
                  type:this.formInline.type
              }
          )

      ).then(response=>{      //返回值部分
          this.candidate = response.data;
          console.log(response.data)
          for(let i=0;i<this.candidate.length;i++){
              this.candidate[i].imgurl = require("../assets/Candidate/"+this.candidate[i].imgurl+".jpg");

          }

      }).catch(error=>{
          console.log(error)
      });





  },
  name: 'Home',
  components: {
    HelloWorld,
    BottomComponents
  },

    mounted(){
        this.ready();

        this.add();
    },
    methods:{
      //分页
        handleSizeChange(val) {
            this.pagesize = val
            this.page = 1
            this.$axios.post('HomeController/selectcandidatebytype',
                this.$qs.stringify(
                    {
                        inf:this.formInline.inf,
                        type:this.formInline.type,
                        pageNo:this.page,
                        pageSize:this.pagesize
                    }
                )

            ).then(response=>{      //返回值部分
                this.candidate = response.data;
                console.log(response.data)
                for(let i=0;i<this.candidate.length;i++){
                    this.candidate[i].imgurl = require("../assets/Candidate/"+this.candidate[i].imgurl+".jpg");

                }

            }).catch(error=>{
                console.log(error)
            });
            console.log(`每页 ${val} 条`);
        },
        handleCurrentChange(val) {
            this.page = val;
            this.$axios.post('HomeController/selectcandidatebytype',
                this.$qs.stringify(
                    {
                        inf:this.formInline.inf,
                        type:this.formInline.type,
                        pageNo:this.page,
                        pageSize:this.pagesize
                    }
                )

            ).then(response=>{      //返回值部分
                this.candidate = response.data;
                console.log(response.data)
                for(let i=0;i<this.candidate.length;i++){
                    this.candidate[i].imgurl = require("../assets/Candidate/"+this.candidate[i].imgurl+".jpg");

                }

            }).catch(error=>{
                console.log(error)
            });
            console.log(`当前页: ${val}`);
        },
      //点击查看
        candidateinf(cid){
            this.$router.push({
                path:'/ticket' ,

                query:{
                    cid:cid
                }
            })
        },
      //根据条件查询
        onSubmit() {

                this.$axios.post('HomeController/selectcandidatebytype',
                    this.$qs.stringify(
                        {
                            inf:this.formInline.inf,
                            type:this.formInline.type,
                            pageNo:1,
                            pageSize:this.pagesize
                        }
                    )

                ).then(response=>{      //返回值部分
                    this.candidate = response.data;
                    console.log(response.data)
                    for(let i=0;i<this.candidate.length;i++){
                        this.candidate[i].imgurl = require("../assets/Candidate/"+this.candidate[i].imgurl+".jpg");

                    }

                }).catch(error=>{
                    console.log(error)
                });



        },
      enter(){
          this.$router.push("/enter")
      },
        ready(){
            var cip = returnCitySN["cip"];
            console.log(cip);//cip就是本机ip地址

        },
        num(n) {
            return n < 10 ? '0' + n : '' + n
        },
        // 倒计时函数
        add() {
            let time = window.setInterval( ()=> {
                if (this.hours !== 0 && this.minutes === 0 && this.seconds === 0) {
                    this.hours -= 1;
                    this.minutes = 59;
                    this.seconds = 59;
                } else if (this.hours === 0 && this.minutes !== 0 && this.seconds ===
                    0) {
                    this.minutes -= 1;
                    this.seconds = 59;
                } else if (this.day !== 0 &&this.hours === 0 && this.minutes === 0 && this.seconds ===
                    0) {
                    this.seconds = 0
                    this.day -=1;
                    // window.clearInterval(time)
                } else if (this.hours !== 0 && this.minutes !== 0 && this.seconds ===
                    0) {
                    this.minutes -= 1;
                    this.seconds = 59;
                }
                else if(this.day === 0&&this.hours === 0 && this.minutes === 0 && this.seconds ===
                    0)
                    {
                        window.clearInterval(time)
                }
                else {
                    this.seconds -= 1;
                }
            }, 1000)
        }

    },
    watch: {
        // 监听数值变化
        second: {
            handler(newVal) {
                this.num(newVal)
            }
        },
        minute: {
            handler(newVal) {
                this.num(newVal)
            }
        },
        hour: {
            handler(newVal) {
                this.num(newVal)
            }
        }},
    computed: {
        // 初始化数据
        second() {
            return this.num(this.seconds)
        },
        minute() {
            return this.num(this.minutes)
        },
        hour() {
            return this.num(this.hours)
        }
    }


}
</script>

<style>
/*<!--   访问量等信息 -->*/
    .home .number{
       background-color: darkgray;
        position: relative;

        height: 100px;
    }
    .home .number .enter{
        position: absolute;
        top: 10px;
        left: 50px;

    }
    .home .number .ticket{
        position: absolute;
        top: 10px;
        left: 150px;
    }
    .home .number .look{
        position: absolute;
        top: 10px;
        left: 250px;
    }
    .bottomsp{
        height: 130px;
    }
</style>
