<template>
    <div>

       <div class="ticket_inf">
           <div v-for="(item,index) in candidate" :key="item" style="border: 1px solid darkgray" >
              <div class="ticket_inf_02">
                  <img :src="item.imagesList[0].imgurl" width="100px"> <span class="firstimg">名字：{{item.cname}} </span><br>
                  <div>编号 &nbsp;<span style="margin-left: 15px">{{item.cid}}</span></div>
                  <div>票数 &nbsp;<span style="margin-left: 15px">{{item.tickets}}</span></div>

                  <div>热度 &nbsp;<span style="margin-left: 15px">{{item.hots}}</span></div>
                  <div>礼物 &nbsp;<span style="margin-left: 15px">{{item.gifts}}</span></div>
              </div>

               <div style="margin: 10px">{{item.cdeclaration}}</div>
               <el-carousel indicator-position="outside" style="border: darkgray 1px solid">
                   <el-carousel-item v-for="(item2) in item.imagesList" :key="item2">

                       <img :src="item2.imgurl" width="300px">
                   </el-carousel-item>
               </el-carousel>






           </div>

           <div style="margin-top: 20px">
               <el-button @click="gohome()">回首页</el-button>
               <el-button @click="giveticket()">投票</el-button>
               <el-button @click="givegift()">礼物</el-button>

           </div>

       </div>


        <BottomComponents></BottomComponents>

    </div>

</template>
<script>
    import BottomComponents from '@/components/BottomComponents.vue'
    export default {
        data(){

            return{
                cid:this.$route.query.cid,
                candidate:{

                },

            }
        },
        created() {
            //向后台查找，返回关于这个选手的所有信息，包括选手表和图库信息       selectcandidateimages
            this.$axios.post('TicketController/selectcandidateimages',
                this.$qs.stringify(
                    {
                       cid:this.cid
                    }
                )

            ).then(response=>{      //返回值部分
                this.candidate = response.data;
                console.log(this.candidate)
                for(let i=0;i<this.candidate[0].imagesList.length;i++){

                    this.candidate[0].imagesList[i].imgurl = require("../assets/Candidate/"+this.candidate[0].imagesList[i].imgurl+".jpg");

                }
            }).catch(error=>{
                console.log(error)
            });



        },
        components :{
            BottomComponents
        },
        methods:{
            gohome(){
                this.$router.push("/")
            },
            giveticket(){
                var cip = returnCitySN["cip"];
                // alert(cip);//cip就是本机ip地址
                  //前端显示 +1
                 this.candidate[0].tickets += 1;
                this.candidate[0].hots += 5;
                //后台数据库部分加1
                this.$axios.post('TicketController/addticket',
                    this.$qs.stringify(
                        {
                            cid:this.cid,
                            ip:cip
                        })
                ).then(response=>{      //返回值部分
                }).catch(error=>{
                    console.log(error)
                });
            },
            givegift(){
                this.$router.push({
                    path:'/gift' ,               	//目标URL，为注册的路由

                    query:{
                        cid:this.cid      	//传入参数，参数会写入URL，params用法同query，只不过参数不会写进URL
                    }
                })
            },
        }
    }
</script>
<style>
    .ticket_inf_02{
        height: 200px;
        background-color: #42b983;
    }

    .firstimg{
        position: relative;
        top: -20px;
        right: -20px;
    }
</style>
















