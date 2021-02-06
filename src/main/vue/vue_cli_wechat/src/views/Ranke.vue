<template>
    <div>

        <div v-for="(item,index) in candidate" class="ranke_inf"  @click="candidateinf(item.cid)">


            <img class="router_buy_all_img" :src=item.imgurl width="100px" ><br>
            <span style="font-size: 20px" class="ranke_inf_ranke">排名:{{index+1}}</span> <br>
            <div class="ranke_inf_id">
                选手id:<span>{{item.cid}}</span> <br>
                选手票数:<span>{{item.tickets}}</span> <br>
                选手礼物:<span>{{item.gifts}}</span> <br>
            </div>



        </div>

        <div style="height: 200px"></div>


        <BottomComponents></BottomComponents>

    </div>

</template>
<script>
    import BottomComponents from '@/components/BottomComponents.vue'
    export default {
        data(){

            return{
                candidate:{}
            }
        },
        components :{
            BottomComponents
        },
        created() {
            // selectcandidateranke
            this.$axios.post('RankeController/selectcandidateranke',
                this.$qs.stringify(
                    {
                    })
            ).then(response=>{
                this.candidate = response.data;
                console.log(response.data)
                for(let i=0;i<this.candidate.length;i++){
                    this.candidate[i].imgurl = require("../assets/Candidate/"+this.candidate[i].imgurl+".jpg");

                }
            }).catch(error=>{
                console.log(error)
            });
        },
        methods:{
            candidateinf(cid){
                this.$router.push({
                    path:'/ticket' ,

                    query:{
                        cid:cid
                    }
                })
            },
        }
    }
</script>

<style>
    .ranke_inf_id{
        position: absolute;
        top: 50px;
        right: 40px;
    }
    .ranke_inf img{
position: absolute;
        left: 80px;
        top: 40px;
    }
    .ranke_inf_ranke{
        position: absolute;
        top: 10px;
        left: 10px;
    }
    .ranke_inf{
height: 150px;
        position: relative;
        border-bottom: solid 1px black;
        border-top: solid 1px black;
    }
</style>