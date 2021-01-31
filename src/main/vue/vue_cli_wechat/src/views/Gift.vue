<template>
    <div>

        <div v-for="(item,index) in giftlist" :key="item" style="border: 1px solid darkgray" >
            <div class="gift" >
                <img :src="item.lwimg" width="100px">  <br>
                <div>名字 &nbsp;<span style="margin-left: 15px">{{item.lwname}}</span>  <br>
                点数 :&nbsp;<span style="margin-left: 15px">{{item.dianshu}}</span> <br>
                价格 &nbsp;:&nbsp;<span style="margin-left: 15px">{{item.price}}</span></div>
                &nbsp;<el-button type="success" @click="givegift(item.lwid,item.lwname,item.dianshu)">送一个</el-button><br>


            </div>







        </div>
        <br>
        <el-button @click="goback" >返回</el-button>

        <div style="height: 200px"></div>


        <BottomComponents></BottomComponents>

    </div>

</template>
<script>
    import BottomComponents from '@/components/BottomComponents.vue'
    export default {
        data(){

            return{
                cid:this.$route.query.cid,
                giftlist:{},
                gift_inf:'1'
            }
        },
        components :{
            BottomComponents
        },
        created() {
            //读取礼物表所有的信息
            //从后台获取数据
            //向后台查找，返回关于这个选手的所有信息，包括选手表和图库信息       selectcandidateimages
            this.$axios.post('GiftController/selectallgift',
                this.$qs.stringify(
                    {

                    }
                )

            ).then(response=>{      //返回值部分
                this.giftlist = response.data;
                console.log(this.giftlist)
                for(let i=0;i<this.giftlist.length;i++){

                    this.giftlist[i].lwimg = require("../assets/gift/"+ this.giftlist[i].lwimg);

                }
            }).catch(error=>{
                console.log(error)
            });
        },
        methods:{
            goback(){
                this.$router.go(-1);
            },
            givegift(lwid,lwname,dianshu){
                var cip = returnCitySN["cip"];
                this.$axios.post('GiftController/givegift',
                    this.$qs.stringify(
                        {
                              lwid:lwid,
                              cid : this.cid,
                              ip:cip,
                            dianshu:dianshu
                        }
                    )

                ).then(response=>{      //返回值部分

                }).catch(error=>{
                    console.log(error)
                });

                this.$message({
                    message: '恭喜你，赠送礼物'+lwname+'成功',
                    type: 'success'
                });
            }
        }
    }
</script>

<style>

</style>