<template>
    <div class="bottomComponents">
<!--        首页-->
        <div class="goFirstPage">
            <i class="el-icon-s-home" @click="goFirstPage()" ></i>
            <div>首页</div>
        </div>

<!--        报名页面-->
        <div class="goEnter">
        <i class="el-icon-user-solid" @click="goEnter()"></i>
            <div>
                报名
            </div>
        </div>
<!--        奖品页面-->
         <div class="goAward">
        <i class="el-icon-present" @click="goAward()"></i>
             <div>
               奖品
             </div>
         </div>
<!--        排行-->
        <div class="goRanke">
        <i class="el-icon-trophy" @click="goRanke()"></i>
            <div>
               排行
            </div>
         </div>

    </div>
</template>

<script>
    export default {
        data(){
            return{

            }
        },
        name: 'BottomComponents',
        props: {

        },
        methods:{
            //跳转到首页
            goFirstPage(){
                this.$router.push({path:'/'});
            },
            //跳转到报名页面
            goEnter(){
                this.$router.push({path:'/enter'});
            },
            //跳转到奖品页面
            goAward(){
                this.$router.push({path:'/award'});
            },
            //跳转到排名页面
            goRanke(){
                this.$router.push({path:'/ranke'});
            },

        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
    .bottomComponents{
        z-index: 99999;
        position: fixed;
        bottom: 0px;
        background-color: white;
        border-top: 1px solid #42b983;
        height: 100px;
        width: 100%;
       left: 0px;
    }
    /*图标大小*/
    .bottomComponents i{
        font-size: 35px;
        margin-bottom: 10px;
    }
    /*首页*/
    .bottomComponents .goFirstPage{
       position: absolute;
        bottom: 5px;
        left: 30px;
    }
    /*报名*/
    .bottomComponents .goEnter{
        position: absolute;
        bottom: 5px;
        left: 120px;
    }
    /*奖品*/
    .bottomComponents .goAward{
        position: absolute;
        bottom: 5px;
        left: 210px;
    }
    /*排行*/
    .bottomComponents .goRanke{
        position: absolute;
        bottom: 5px;
        left: 300px;
    }
</style>