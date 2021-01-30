<template>
    <div>



        <div class="present_inf1">奖品列表</div>
        <br>

        <div v-for="(item,index) in presentList"  class="present" style="border: 1px solid darkgray">


            <img class="present_img" :src=item.pimg width="100px" height="100px">
            <div class="present_inf">   活动:<span>{{item.aid}}</span> <br>
                奖品名称:<span>{{item.pname}}</span><br>
                奖品价格:<span>{{item.pcount}}</span><br>
                奖品等级:<span>{{item.level}}</span><br></div>

        </div>
        <BottomComponents></BottomComponents>



    </div>

</template>
<script>
    import BottomComponents from '@/components/BottomComponents.vue'
    export default {
        data() {
            return {
                presentList:{}
            }
        },
        created() {
            //从后台获取奖品数据  selectallpresent
            this.$axios.post('PresentController/selectallpresent',
                this.$qs.stringify(
                    {
                        aid:1
                    }
                )

            ).then(response=>{      //返回值部分
                this.presentList = response.data
                for(let i=0;i<this.presentList.length;i++){
                    this.presentList[i].pimg = require("../assets/present/"+this.presentList[i].pimg);
                    console.log(this.presentList[i].pimg)

                }
            }).catch(error=>{
                console.log(error)
            });

        },

        methods:{

        },


        components :{
            BottomComponents
        }
    }
</script>
<style>

</style>




